package com.bishwajeet.gifsearch.ui


private const val MINIMUM_QUERY_LENGTH = 2

const val GIF_ID = "id"
const val GIF_QUERY = "query"

fun getFormattedQueryString(rawQuery: String?): String {
    return if (rawQuery.isNullOrEmpty() || rawQuery.length <= MINIMUM_QUERY_LENGTH) {
        ""
    } else {
        if (rawQuery.length.rem(2) == 1) {
            rawQuery
        } else {
            rawQuery.dropLast(1)
        }
    }
}


fun isValidQuery(queryString: String): Boolean {
    return queryString.length > MINIMUM_QUERY_LENGTH
}


