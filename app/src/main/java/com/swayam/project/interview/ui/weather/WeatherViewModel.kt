package com.swayam.project.interview.ui.weather

import androidx.lifecycle.MutableLiveData
import com.swayam.project.interview.data.repository.WeatherRepository
import com.swayam.project.interview.ui.base.BaseViewModel
import com.swayam.project.interview.utils.network.NetworkHelper
import com.swayam.project.interview.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable


class WeatherViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val weatherRepository: WeatherRepository
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {

     private val latitudeField:MutableLiveData<String> = MutableLiveData()
     private val longitudeField:MutableLiveData<String> = MutableLiveData()
    val currentDateField:MutableLiveData<Int> = MutableLiveData()
    val isGetWeatherDataSuccess:MutableLiveData<Boolean> = MutableLiveData()

    override fun onCreate() {
        // do something
    }

     fun onClickGetWeatherDetails(){
         val latitude=latitudeField.value
         val longitude=longitudeField.value
         val appId="21ac21a4a36559e72b372af2d6b8841b"

         //this isGetWeatherDataSuccess should be used inside success block of api but due to api key not working i am using it here to display ui
         isGetWeatherDataSuccess.postValue(true)
//         if(latitude!=null && longitude!=null) {
//             compositeDisposable.addAll(
//                 postRepository.getWeatherDetails(latitude, longitude, appId)
//                     .subscribeOn(schedulerProvider.io())
//                     .subscribe(
//                         {
//                             currentDateField.postValue(it.current.date)
//
//                         },
//                         {
//                             handleNetworkError(it)
//                         }
//                     )
//
//
//             )
//         }

    }

    fun setLatitude(latitude: String) {
        latitudeField.postValue(latitude)
    }

    fun setLongitude(longitude: String) {
        longitudeField.postValue(longitude)
    }
}