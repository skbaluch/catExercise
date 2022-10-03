package com.newrelic.mobile.challenge

import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import com.google.gson.Gson
import com.newrelic.mobile.challenge.models.BreedsModel
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

    val networkRequest = NetworkRequest.Builder()
        .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
        .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
        .build()

    private fun isNetworkConnected(): Boolean {
        val networkCallback = object : ConnectivityManager.NetworkCallback() {
            // network is available for use
            override fun onAvailable(network: Network) {
                super.onAvailable(network)
            }

            // Network capabilities have changed for the network
            override fun onCapabilitiesChanged(
                network: Network,
                networkCapabilities: NetworkCapabilities
            ) {
                super.onCapabilitiesChanged(network, networkCapabilities)
                val unmetered =
                    networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_NOT_METERED)
            }

            // lost network connection
            override fun onLost(network: Network) {
                super.onLost(network)
            }
        }
        return true
    }

    fun getBreeds(queryParameters: String?): BreedsModel {
        if (isNetworkConnected()) {
            val catFactsUri = "$CATFACT_API/breeds" + (queryParameters ?: QUERY)
            val resultsAsJson = URL(catFactsUri).readText()
            return gson.fromJson(resultsAsJson, BreedsModel::class.java)
        } else {
            // this won't trigger unless it is clicked
            MainActivity().showAlertDialog()
        }
            return BreedsModel()
        }

        fun getCatFact(): BreedsModel {
            if (isNetworkConnected()) {
                val catFactsUri = "$CATFACT_API/fact"
                val resultsAsJson = URL(catFactsUri).readText()
                return gson.fromJson(resultsAsJson, BreedsModel::class.java)
            } else {
                // this won't trigger unless it is clicked
                MainActivity().showAlertDialog()
            }
            return BreedsModel()
        }
    }
