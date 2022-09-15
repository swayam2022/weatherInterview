package com.swayam.project.interview

import android.app.Application
import com.swayam.project.interview.di.component.ApplicationComponent
import com.swayam.project.interview.di.component.DaggerApplicationComponent
import com.swayam.project.interview.di.module.ApplicationModule

class WeatherApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }

    // Needed to replace the component with a test specific one
    fun setComponent(applicationComponent: ApplicationComponent) {
        this.applicationComponent = applicationComponent
    }
}