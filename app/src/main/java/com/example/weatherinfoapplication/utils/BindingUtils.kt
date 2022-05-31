package com.example.weatherinfoapplication.utils

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.text.SimpleDateFormat
import java.util.*

class BindingUtils {


    companion object {
        @JvmStatic
        @BindingAdapter("formattedDate")
        fun formattedText(view: View, date: Long?) {
            (view as TextView).text = if (date == null) {
                ""
            } else {
                val fmt = SimpleDateFormat("dd-MM-yyyy")
                val date = Date(date * 1000)
                val date1 = fmt.format(date)
                date1
            }
        }
    }

}