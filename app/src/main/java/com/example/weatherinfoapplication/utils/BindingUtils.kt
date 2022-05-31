package com.example.weatherinfoapplication.utils

import android.text.format.DateUtils
import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.text.SimpleDateFormat
import java.util.*

public class BindingUtils {

    @BindingAdapter("isVisible")
    fun setIsVisible(view: View, isVisible: Boolean) {
        if (isVisible) {
            view.visibility = View.VISIBLE
        } else {
            view.visibility = View.GONE
        }
    }


    public fun formatDateWithPattern(date: Long): String {
        val fmt = SimpleDateFormat("dd-MM-yyyy")
        val date = Date(date * 1000)
        return fmt.format(date)
    }


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