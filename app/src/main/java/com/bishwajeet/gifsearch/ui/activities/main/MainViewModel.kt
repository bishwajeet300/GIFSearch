package com.bishwajeet.gifsearch.ui.activities.main

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.bishwajeet.gifsearch.model.GifSearchUIModel
import com.bishwajeet.gifsearch.model.GifUIModel
import com.bishwajeet.gifsearch.model.Result
import com.bishwajeet.gifsearch.repository.gifRepository.GifRepository
import com.bishwajeet.gifsearch.ui.GIF_QUERY
import com.bishwajeet.gifsearch.ui.fragments.result.GifDetailResult
import com.bishwajeet.gifsearch.ui.fragments.search.GifSearchAction
import com.bishwajeet.gifsearch.ui.getFormattedQueryString
import com.bishwajeet.gifsearch.ui.isValidQuery
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel @ViewModelInject constructor(
    private val gifRepository: GifRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _gifResult = MutableLiveData<GifDetailResult>()
    private var _isValidQuery = MutableLiveData<Boolean>()
    private val _currentInputQuery = MutableLiveData<String>()

    private var currentQueryValue: String = ""
    private var currentSearchResult: Flow<PagingData<GifSearchUIModel>>? = null

    val gifDetailResult: LiveData<GifDetailResult> = _gifResult
    var isValidQuery: LiveData<Boolean> = _isValidQuery


    private fun getRandomGif() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = gifRepository.getRandomGif()) {
                is Result.Success -> {
                    withContext(Dispatchers.Main) {
                        _gifResult.value =
                            GifDetailResult(
                                success = GifUIModel(
                                    title = result.data.title.ifBlank { "Animated GIF" },
                                    gif_url = result.data.gif_url,
                                    rating = result.data.rating
                                )
                            )
                    }
                }
                is Result.Error -> {
                    withContext(Dispatchers.Main) {
                        _gifResult.value =
                            GifDetailResult(error = result.exception)
                    }
                }
            }
        }
    }


    private fun isValidSearchQuery(queryString: String) {
        savedStateHandle.set(GIF_QUERY, queryString)
        _currentInputQuery.value = queryString
        _isValidQuery.value = isValidQuery(queryString)
    }


    fun searchGif(): Flow<PagingData<GifSearchUIModel>> {
        val queryString = getFormattedQueryString(_currentInputQuery.value)

        val lastResult = currentSearchResult

        if (queryString == currentQueryValue && lastResult != null) {
            return lastResult
        }
        val newResult: Flow<PagingData<GifSearchUIModel>> =
            gifRepository.getGifSearchResultStream(queryString)
                .map { pagingData ->
                    pagingData.map { gifDataModel -> GifSearchUIModel(gifDataModel) }
                }
                .cachedIn(viewModelScope)
        currentSearchResult = newResult
        return newResult
    }


    fun receiveUserAction(gifSearchAction: GifSearchAction) {
        when (gifSearchAction) {
            is GifSearchAction.SearchQueryInput -> isValidSearchQuery(gifSearchAction.query)
            GifSearchAction.ScreenOpen -> getRandomGif()
        }
    }
}