package com.example.weatherinfoapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherinfoapplication.R
import com.example.weatherinfoapplication.databinding.WeatherListItemViewBinding
import com.example.weatherinfoapplication.model.Daily

class WeatherListAdapter(var weatherData: List<Daily>) : RecyclerView.Adapter<WeatherListAdapter.WeatherListViewHolder>() {

   lateinit var onClickListener : OnClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherListViewHolder {
        var binding: WeatherListItemViewBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.weather_list_item_view,
                parent,
                false
            )

        return WeatherListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeatherListViewHolder, position: Int) {
        var dailyWeather = weatherData.get(position)
        holder.weatherBinding.data = dailyWeather
        holder.itemView.setOnClickListener { onClickListener.onItemClick(position, holder.itemView) }
    }

    override fun getItemCount(): Int {
        if(weatherData != null){
            return weatherData.count()
        }else{
            return 0
        }
    }


    fun setData(dataList : List<Daily>){
        weatherData = dataList
        notifyDataSetChanged()
    }

    class WeatherListViewHolder(binding: WeatherListItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
            var weatherBinding : WeatherListItemViewBinding = binding
    }

    fun setOnItemClickListener(onClickListener: OnClickListener){
        this.onClickListener = onClickListener
    }

    interface OnClickListener{
        fun onItemClick(position: Int, view: View)
    }

}