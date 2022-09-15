package com.swayam.project.interview.data.remote.response

import com.google.gson.annotations.SerializedName

data class WeatherDetailsResponse(
    @SerializedName("lat")
    val lat:Double,
    @SerializedName("lon")
    val lon:Double,
    @SerializedName("current")
    val current:Current,

){
    data class Current(
        @SerializedName("dt")
        val date:Int?,
        @SerializedName("sunrise")
        val sunRise:Int?
    )
}
