package com.newrelic.mobile.challenge

import com.google.gson.Gson
import com.newrelic.mobile.challenge.models.BreedsModel
import com.newrelic.mobile.challenge.models.CatFactModel
import java.net.URL

class CatFactsDataSource {

    private val gson = Gson()

    companion object {
        private const val CATFACT_API = "https://catfact.ninja"
        private const val QUERY = "?limit=30"

        @Volatile
        private var INSTANCE: CatFactsDataSource? = null
        fun getInstance() =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: CatFactsDataSource().also {
                    INSTANCE = it
                }
            }
    }

    private fun isNetworkConnected(): Boolean {
        return true     // FIXME
    }

    fun getBreeds(queryParameters: String?): BreedsModel {
        if (isNetworkConnected()) {
            val catFactsUri = "$CATFACT_API/breeds" + (queryParameters ?: QUERY)
            val resultsAsJson = URL(catFactsUri).readText()
            return gson.fromJson(resultsAsJson, BreedsModel::class.java)
        } else {
            TODO("Alert the user in this case")
        }
        return BreedsModel()
    }

    fun getCatFact(): CatFactModel {
        TODO("Return a random cat fact")
    }

}