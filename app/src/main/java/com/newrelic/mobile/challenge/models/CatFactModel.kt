package com.newrelic.mobile.challenge.models

data class CatFactModel(
    val fact: String?,
    val length: Int
){
    constructor() : this("fact", 1)
}
