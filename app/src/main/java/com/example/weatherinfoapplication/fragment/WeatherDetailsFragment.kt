package com.example.weatherinfoapplication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.weatherinfoapplication.R
import com.example.weatherinfoapplication.databinding.FragmentWeatherDetailsBinding
import com.example.weatherinfoapplication.viewmodel.WeatherViewModel


class WeatherDetailsFragment : Fragment() {

    lateinit var binding: FragmentWeatherDetailsBinding
    lateinit var viewModel: WeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_weather_details,
            container,
            false
        )

        viewModel = ViewModelProvider(requireActivity()).get(WeatherViewModel::class.java)
        binding.viewModel = viewModel
        println(viewModel.details.toString())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}