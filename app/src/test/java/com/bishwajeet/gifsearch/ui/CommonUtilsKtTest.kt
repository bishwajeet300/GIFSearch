package com.bishwajeet.gifsearch.ui

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CommonUtilsKtTest {

    @Test
    fun getFormattedQueryString_Test() {

        for (entry in sampleInputOutputMap) {
            assertEquals(getFormattedQueryString(entry.key), entry.value)
        }
    }


    companion object {
        val sampleInputOutputMap = hashMapOf(
            "" to "",
            "a" to "",
            "ab" to "",
            "abc" to "abc",
            "abcd" to "abc",
            "abcde" to "abcde",
            "abcdef" to "abcde",
            "abcdefg" to "abcdefg"
        )
    }
}