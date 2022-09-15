package com.swayam.project.interview.di.component

import com.swayam.project.interview.di.ActivityScope
import com.swayam.project.interview.di.module.ActivityModule
import com.swayam.project.interview.ui.weather.WeatherActivity
import dagger.Component

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent {


    fun inject(activity: WeatherActivity)

}