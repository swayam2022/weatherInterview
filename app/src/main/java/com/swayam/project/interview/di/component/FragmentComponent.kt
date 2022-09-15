package com.swayam.project.interview.di.component

import com.swayam.project.interview.di.FragmentScope
import com.swayam.project.interview.di.module.FragmentModule
import dagger.Component

@FragmentScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [FragmentModule::class]
)
interface FragmentComponent {

}