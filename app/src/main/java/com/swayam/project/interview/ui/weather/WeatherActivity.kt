package com.swayam.project.interview.ui.weather

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.swayam.project.interview.R
import com.swayam.project.interview.databinding.ActivityWeatherBinding
import com.swayam.project.interview.di.component.ActivityComponent
import com.swayam.project.interview.ui.base.BaseActivity

class WeatherActivity : BaseActivity<WeatherViewModel>() {

    companion object {
        const val TAG = "WeatherActivity"
    }
    lateinit var binding: ActivityWeatherBinding
    override fun provideLayoutId(): Int = R.layout.activity_weather

    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun setupView(savedInstanceState: Bundle?) {
         binding =
            DataBindingUtil.setContentView(this, R.layout.activity_weather)
        binding.viewModel=viewModel
        setUpEditText()
    }

    private fun setUpEditText() {
        binding.etLatitude.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.setLatitude(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })
        binding.etLongitude.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.setLongitude(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
    }

    override fun setupObservers() {
        super.setupObservers()
        viewModel.currentDateField.observe(this, Observer {
            binding.tvDate.text=it.toString()
        })
        viewModel.isGetWeatherDataSuccess.observe(this, Observer {
            if(it==true)
                binding.cvCurrently.visibility= View.VISIBLE
            binding.cvHourly.visibility= View.VISIBLE
            binding.cvDaily.visibility=View.VISIBLE
        })
    }


}