package com.example.weatherinfoapplication.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherinfoapplication.model.Daily
import com.example.weatherinfoapplication.retrofit.Repository
import com.example.weatherinfoapplication.retrofit.ServiceCall
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject

class WeatherViewModel : ViewModel() {

    var dataService :ServiceCall = Repository.createService()
    var dataSubject : BehaviorSubject<List<Daily>> = BehaviorSubject.create()
    var detailDataSubject : BehaviorSubject<Daily> = BehaviorSubject.create()
    lateinit var details : Daily

    fun getWeatherData() {
         dataService.getData(18,73,"current,minutely,hourly","ebd7a70eb498eb3e90228c23fdeecb3b")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    println("Data observable ${it}")
                    dataSubject.onNext(it.daily)
                },{
                  Log.d("Error", it.localizedMessage)
                }
            )
    }
}