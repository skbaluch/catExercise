package com.newrelic.mobile.challenge.models

data class DetailModel(
    val breed: String?,
    val country: String?,
    val origin: String?,
    val coat: String?,
    val pattern: String?
) {
    constructor() : this("street", "anywhere", "egypt", "mangy", "camo")
}
