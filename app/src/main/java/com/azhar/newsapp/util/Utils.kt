package com.azhar.newsapp.util

import org.ocpsoft.prettytime.PrettyTime
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Azhar Rivaldi on 10-04-2021
 * Github : https://github.com/AzharRivaldi
 * Linkedin : https://www.linkedin.com/in/azhar-rivaldi
 * Instagram : https://www.instagram.com/azhardvls_
 * Twitter : https://twitter.com/azharrvldi_
 * Youtube Channel : https://bit.ly/2PJMowZ
 */

object Utils {

    fun DateTimeHourAgo(dateTime: String?): String? {
        val prettyTime = PrettyTime(Locale.getDefault())
        var isTime: String? = null
        try {
            val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
            val date = simpleDateFormat.parse(dateTime)
            isTime = prettyTime.format(date)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return isTime
    }

    fun DateFormat(dateNews: String?): String? {
        val isDate: String?
        val dateFormat = SimpleDateFormat("MMMM dd, yyyy - HH:mm:ss", Locale(getCountry()))
        isDate = try {
            val date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(dateNews)
            dateFormat.format(date)
        } catch (e: ParseException) {
            e.printStackTrace()
            dateNews
        }
        return isDate
    }

    fun getCountry(): String {
        val locale = Locale.getDefault()
        val strCountry = locale.country
        return strCountry.toLowerCase()
    }
}