package com.albumviewer.network

import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Factory class to build the Retrofit instance.
 */
object ApiFactory {

    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    fun create(): ApiEndpoint {

        // create an RxJava Adapter, network calls made asynchronous
        val rxAdapter = RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())

        // Build retrofit object
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(rxAdapter)
            .build()

        return retrofit.create(ApiEndpoint::class.java)
    }
}