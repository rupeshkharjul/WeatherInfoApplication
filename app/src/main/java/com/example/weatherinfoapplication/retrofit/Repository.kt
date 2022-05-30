package com.example.weatherinfoapplication.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class Repository {

    companion object{
        val BASE_URL: String = "https://api.openweathermap.org/data/2.5/"

        private val httpClient = OkHttpClient.Builder()

        private val builder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

        fun createService(): ServiceCall  {
            val client = httpClient.build()
            val retrofit = builder.client(client).build()
            return retrofit.create(ServiceCall::class.java)
        }
    }
}