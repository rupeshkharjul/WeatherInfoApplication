package com.example.weatherinfoapplication.retrofit

import com.example.weatherinfoapplication.model.Data
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ServiceCall {

    @GET("onecall?")
    fun getData(
        @Query("lat") lat: Long,
        @Query("lon") lon: Long,
        @Query("exclude") exclude: String,
        @Query("appid") appid: String
    ) : Observable<Data>
}