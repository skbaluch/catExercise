package com.newrelic.mobile.challenge.models

data class MetricsModel(
    val deviceName: String?,
    val osName: String?
) {
    constructor() : this("newton", "pda")
}
