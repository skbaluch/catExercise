package com.newrelic.mobile.challenge.models

data class BreedsModel(
    val current_page: Int,
    val data: MutableList<DetailModel>,
    val first_page_url: String?,
    val from: Int,
    val last_page: Int,
    val last_page_url: String?,
    val next_page_url: String?,
    val path: String?,
    val per_page: Int,
    val prev_page_url: String?,
    val to: Int,
    val total: Int
) {
    constructor() : this(
        1,
        mutableListOf(DetailModel()),
        "localhost",
        1,
        1,
        null,
        null,
        null,
        1,
        null,
        1,
        1
    )
}
