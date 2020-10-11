package com.bishwajeet.gifsearch.ui

import android.Manifest
import android.graphics.Bitmap
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.runner.permission.PermissionRequester
import androidx.test.runner.screenshot.Screenshot
import com.bishwajeet.gifsearch.R
import com.bishwajeet.gifsearch.ui.activities.main.MainActivity
import com.bishwajeet.gifsearch.ui.fragments.search.GifViewHolder
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class ScreenShotTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun init() {
        hiltRule.inject()
        PermissionRequester().apply {
            addPermissions(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
            requestPermissions()
        }
    }

    @Test
    fun test_CopyLinkToastWithScreenshot() {
        //Given
        launchActivity<MainActivity>()

        //When
        onView(withId(R.id.etSearch)).perform(ViewActions.replaceText("toy"))
        Thread.sleep(10000)
        onView(withId(R.id.list))
            .perform(RecyclerViewActions.scrollToPosition<GifViewHolder>(10))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<GifViewHolder>(
                    10,
                    click()
                )
            )
        onView(withId(R.id.btnCopy)).perform(click())

        //Then
        captureScreenshot("${System.currentTimeMillis()}")
    }

    /**
     * Stores captured screenshot in the device "Screenshot" folder
     * */
    private fun captureScreenshot(name: String) {
        val capture = Screenshot.capture()
        capture.format = Bitmap.CompressFormat.PNG
        capture.name = name
        try {
            capture.process()
        } catch (ex: IOException) {
            throw IllegalStateException(ex)
        }
    }
}