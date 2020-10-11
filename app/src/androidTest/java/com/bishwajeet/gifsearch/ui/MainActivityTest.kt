package com.bishwajeet.gifsearch.ui

import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.bishwajeet.gifsearch.R
import com.bishwajeet.gifsearch.ui.activities.main.MainActivity
import com.bishwajeet.gifsearch.ui.fragments.search.GifViewHolder
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun init() {
        hiltRule.inject()
    }


    @Test
    fun test_DisplayHeading() {
        //Given
        launchActivity<MainActivity>()

        //Then
        onView(withId(R.id.tvHeading)).check(matches(withText("Random selected GIF:")))
    }


    @Test
    fun test_RandomGifVisibilityOnShortQuery() {
        //Given
        launchActivity<MainActivity>()

        //When
        onView(withId(R.id.etSearch)).perform(replaceText("to"))

        //Then
        onView(withId(R.id.resultLayout)).check(matches(isDisplayed()))
    }


    @Test
    fun test_CancelButtonVisibility_shouldBeVisible() {
        //Given
        launchActivity<MainActivity>()

        //When
        onView(withId(R.id.etSearch)).perform(replaceText("toy"))

        //Then
        onView(withId(R.id.txtClose)).check(matches(isDisplayed()))
    }


    @Test
    fun test_CancelButtonVisibility_shouldNotBeVisible() {
        //Given
        launchActivity<MainActivity>()

        //When
        onView(withId(R.id.etSearch)).perform(replaceText("to"))

        //Then
        onView(withId(R.id.txtClose)).check(matches(withEffectiveVisibility(Visibility.GONE)))
    }


    @Test
    fun test_OnCancelButtonClick() {
        //Given
        launchActivity<MainActivity>()

        //When
        onView(withId(R.id.etSearch)).perform(replaceText("toy"))
        onView(withId(R.id.txtClose)).perform(click())

        //Then
        onView(withId(R.id.txtClose)).check(matches(withEffectiveVisibility(Visibility.GONE)))
    }


    @Test
    fun test_SearchResultVisibilityOnValidQuery() {
        //Given
        launchActivity<MainActivity>()

        //When
        onView(withId(R.id.etSearch)).perform(replaceText("toy"))

        //Then
        onView(withId(R.id.list)).check(matches(isDisplayed()))
    }


    @Test
    fun test_SearchResultRecyclerViewScroll() {
        //Given
        launchActivity<MainActivity>()

        //When
        onView(withId(R.id.etSearch)).perform(replaceText("toy"))
        Thread.sleep(10000)
        onView(withId(R.id.list))
            .perform(RecyclerViewActions.scrollToPosition<GifViewHolder>(10))
            .perform(RecyclerViewActions.scrollToPosition<GifViewHolder>(20))
            .perform(RecyclerViewActions.scrollToPosition<GifViewHolder>(30))

        //Then
        onView(withId(R.id.list)).check(matches(isDisplayed()))
    }


    @Test
    fun test_SearchResultRecyclerViewScrollAndClick() {
        //Given
        launchActivity<MainActivity>()

        //When
        onView(withId(R.id.etSearch)).perform(replaceText("toy"))
        Thread.sleep(10000)
        onView(withId(R.id.list))
            .perform(RecyclerViewActions.scrollToPosition<GifViewHolder>(10))
            .perform(RecyclerViewActions.scrollToPosition<GifViewHolder>(20))
            .perform(actionOnItemAtPosition<GifViewHolder>(10, click()))

        //Then
        onView(withId(R.id.tvHeading)).check(matches(isDisplayed()))
    }
}