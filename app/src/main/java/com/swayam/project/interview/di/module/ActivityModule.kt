package com.swayam.project.interview.di.module

import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.swayam.project.interview.data.repository.WeatherRepository
import com.swayam.project.interview.ui.base.BaseActivity
import com.swayam.project.interview.ui.weather.WeatherViewModel
import com.swayam.project.interview.utils.ViewModelProviderFactory
import com.swayam.project.interview.utils.network.NetworkHelper
import com.swayam.project.interview.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import java.util.*

/**
 * Kotlin Generics Reference: https://kotlinlang.org/docs/reference/generics.html
 * Basically it means that we can pass any class that extends BaseActivity which take
 * BaseViewModel subclass as parameter
 */
@Module
class ActivityModule(private val activity: BaseActivity<*>) {

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager = LinearLayoutManager(activity)



    @Provides
    fun provideWeatherViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        weatherRepository: WeatherRepository
    ): WeatherViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(WeatherViewModel::class) {
            WeatherViewModel(schedulerProvider, compositeDisposable, networkHelper, weatherRepository)
        }).get(WeatherViewModel::class.java)


}