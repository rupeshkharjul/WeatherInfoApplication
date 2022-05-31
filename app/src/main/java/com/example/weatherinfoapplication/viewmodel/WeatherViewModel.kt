package com.example.weatherinfoapplication.viewmodel

import androidx.lifecycle.ViewModel
import com.example.weatherinfoapplication.model.Daily
import com.example.weatherinfoapplication.retrofit.Repository
import com.example.weatherinfoapplication.retrofit.ServiceCall
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class WeatherViewModel : ViewModel() {

    var dataService: ServiceCall = Repository.createService()
    var dataSubject: BehaviorSubject<List<Daily>> = BehaviorSubject.create()
    lateinit var details: Daily

    fun getWeatherData() {
        dataService.getData(18, 73, "current,minutely,hourly", "ebd7a70eb498eb3e90228c23fdeecb3b")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    println("Data observable ${it}")
                    dataSubject.onNext(it.daily)
                }, {
                    dataSubject.onError(it)
                }
            )
    }

    fun formatDateWithPattern(): String? {
        val fmt = SimpleDateFormat("dd-MM-yyyy")
        val date = Date(details.dt * 1000)
        return fmt.format(date)
    }


}