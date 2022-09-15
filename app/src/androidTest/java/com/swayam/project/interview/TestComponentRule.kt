package com.swayam.project.interview

import android.content.Context
import com.mindorks.project.interview.di.component.DaggerTestComponent
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class TestComponentRule(private val context: Context) : TestRule {

    private var testComponent: com.swayam.project.interview.di.component.TestComponent? = null

    fun getContext() = context

    private fun setupDaggerTestComponentInApplication() {
        val application = context.applicationContext as com.swayam.project.interview.WeatherApplication
        testComponent = DaggerTestComponent.builder()
            .applicationTestModule(
                com.swayam.project.interview.di.module.ApplicationTestModule(
                    application
                )
            )
            .build()
        application.setComponent(testComponent!!)
    }

    override fun apply(base: Statement, description: Description?): Statement {
        return object : Statement() {
            @Throws(Throwable::class)
            override fun evaluate() {
                try {
                    setupDaggerTestComponentInApplication()
                    base.evaluate()
                } finally {
                    testComponent = null
                }
            }
        }
    }

}