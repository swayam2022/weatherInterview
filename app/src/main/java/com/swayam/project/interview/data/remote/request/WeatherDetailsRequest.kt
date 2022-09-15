package com.swayam.project.interview.data.remote.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WeatherDetailsRequest(
    @Expose
    @SerializedName("lat")
    val latitude:String,
    @Expose
    @SerializedName("lon")
    val longitude:String,
    @Expose
    @SerializedName("appid")
    val apiKey:String


)
