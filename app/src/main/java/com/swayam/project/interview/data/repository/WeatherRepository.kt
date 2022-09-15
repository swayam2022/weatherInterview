package com.swayam.project.interview.data.repository

import com.swayam.project.interview.data.local.db.DatabaseService
import com.swayam.project.interview.data.remote.NetworkService
import com.swayam.project.interview.data.remote.response.WeatherDetailsResponse
import io.reactivex.Single
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val networkService: NetworkService,
    private val databaseService: DatabaseService
) {
    fun getWeatherDetails(lat:String?,lon:String?,appId:String?):Single<WeatherDetailsResponse>{
        return networkService.getWeatherDetails(lat,lon,appId)
    }


}