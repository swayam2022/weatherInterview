package com.swayam.project.interview.di.component

import com.swayam.project.interview.di.ViewModelScope
import com.swayam.project.interview.di.module.ViewHolderModule
import dagger.Component

@ViewModelScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ViewHolderModule::class]
)
interface ViewHolderComponent {

}