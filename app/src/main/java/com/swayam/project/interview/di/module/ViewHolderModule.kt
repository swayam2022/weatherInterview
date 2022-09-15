package com.swayam.project.interview.di.module

import androidx.lifecycle.LifecycleRegistry
import com.swayam.project.interview.di.ViewModelScope
import com.swayam.project.interview.ui.base.BaseItemViewHolder
import dagger.Module
import dagger.Provides

@Module
class ViewHolderModule(private val viewHolder: BaseItemViewHolder<*, *>) {

    @Provides
    @ViewModelScope
    fun provideLifecycleRegistry(): LifecycleRegistry = LifecycleRegistry(viewHolder)
}