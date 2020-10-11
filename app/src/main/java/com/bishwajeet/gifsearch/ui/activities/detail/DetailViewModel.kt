package com.bishwajeet.gifsearch.ui.activities.detail

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.bishwajeet.gifsearch.model.GifUIModel
import com.bishwajeet.gifsearch.model.Result
import com.bishwajeet.gifsearch.repository.gifRepository.GifRepository
import com.bishwajeet.gifsearch.ui.GIF_ID
import com.bishwajeet.gifsearch.ui.fragments.result.GifDetailAction
import com.bishwajeet.gifsearch.ui.fragments.result.GifDetailResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel @ViewModelInject constructor(
    private val gifRepository: GifRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _gifResult = MutableLiveData<GifDetailResult>()
    val gifDetailResult: LiveData<GifDetailResult> = _gifResult


    fun receiveUserAction(gifDetailAction: GifDetailAction) {
        when (gifDetailAction) {
            is GifDetailAction.ScreenOpenWithId -> {
                savedStateHandle.set(GIF_ID, gifDetailAction.id)
                getGifById(gifDetailAction.id)
            }
        }
    }


    private fun getGifById(id: String) {
        viewModelScope.launch(Dispatchers.Main) {
            when (val result = gifRepository.getGifById(id)) {
                is Result.Success -> {
                    _gifResult.value =
                        GifDetailResult(
                            success = GifUIModel(
                                title = result.data.title.ifBlank { "Animated GIF" },
                                gif_url = result.data.gif_url,
                                rating = result.data.rating
                            )
                        )
                }
                is Result.Error -> {
                    _gifResult.value =
                        GifDetailResult(error = result.exception)
                }
            }
        }
    }
}