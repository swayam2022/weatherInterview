package com.swayam.project.interview.data.remote

import com.swayam.project.interview.data.remote.response.*
import io.reactivex.Single
import okhttp3.MultipartBody
import retrofit2.http.*
import javax.inject.Singleton

@Singleton
interface NetworkService {

    @GET(Endpoints.WEATHER_DETAILS)
    fun getWeatherDetails(
        @Query("lat") lat:String?,
        @Query("lon") lon:String?,
        @Query("appid") appId:String?
    ):Single<WeatherDetailsResponse>



}