package com.example.weatherinfoapplication.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherinfoapplication.R
import com.example.weatherinfoapplication.adapter.WeatherListAdapter
import com.example.weatherinfoapplication.databinding.FragmentWeeklyWeatherDataBinding
import com.example.weatherinfoapplication.model.Daily
import com.example.weatherinfoapplication.viewmodel.WeatherViewModel
import kotlin.math.log


class WeeklyWeatherDataFragment : Fragment(),WeatherListAdapter.OnClickListener {

    lateinit var binding : FragmentWeeklyWeatherDataBinding
    lateinit var viewModel : WeatherViewModel
    lateinit var adapter : WeatherListAdapter
    var dataList: List<Daily> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_weekly_weather_data,
            container,
            false
        )

        setupRecyclerView()
        viewModel = ViewModelProvider(requireActivity()).get(WeatherViewModel::class.java)
        binding.viewModel = viewModel
        viewModel.getWeatherData()
        getDataFromObservable()
        return binding.root
    }

    private fun setupRecyclerView() {
       var recyclerView : RecyclerView = binding.rvDailyWeatherData
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        recyclerView.addItemDecoration(DividerItemDecoration(requireContext(),LinearLayoutManager.HORIZONTAL))
        adapter = WeatherListAdapter(dataList)
        adapter.setOnItemClickListener(this)
        recyclerView.adapter = adapter
    }

    private fun getDataFromObservable() {
        viewModel.dataSubject.subscribe(
            {
                dataList = it
                adapter.setData(dataList)
            },
            {
                Toast.makeText(context, it.localizedMessage, Toast.LENGTH_LONG).show()
                Log.e("Error", it.localizedMessage)
            }
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onItemClick(position: Int, view: View) {
        viewModel.details = dataList.get(position)
        println("Click Data: ${viewModel.details}")
        findNavController().navigate(R.id.action_weather_details)
    }

}