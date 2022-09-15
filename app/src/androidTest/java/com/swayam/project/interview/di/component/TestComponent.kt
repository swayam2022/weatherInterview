package com.swayam.project.interview.di.component

import com.swayam.project.interview.di.module.ApplicationTestModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [com.swayam.project.interview.di.module.ApplicationTestModule::class])
interface TestComponent : com.swayam.project.interview.di.component.ApplicationComponent {
}