package com.bishwajeet.gifsearch.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.SavedStateHandle
import com.bishwajeet.gifsearch.getOrAwaitValue
import com.bishwajeet.gifsearch.model.GifUIModel
import com.bishwajeet.gifsearch.repository.gifRepository.GifRepository
import com.bishwajeet.gifsearch.testUtils.MockGifRepository
import com.bishwajeet.gifsearch.ui.activities.main.MainViewModel
import com.bishwajeet.gifsearch.ui.fragments.search.GifSearchAction
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {

    lateinit var mainViewModel: MainViewModel
    lateinit var gifRepository: GifRepository


    @Before
    fun setup() {
        gifRepository = MockGifRepository()
        mainViewModel = MainViewModel(gifRepository, SavedStateHandle())
    }


    @Test
    fun test_random() {

        mainViewModel.receiveUserAction(
            GifSearchAction.ScreenOpen
        )

        assert(mainViewModel.gifDetailResult.getOrAwaitValue().success is GifUIModel)
    }
}