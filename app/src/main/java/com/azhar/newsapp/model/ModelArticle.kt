package com.azhar.newsapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Created by Azhar Rivaldi on 10-04-2021
 * Github : https://github.com/AzharRivaldi
 * Linkedin : https://www.linkedin.com/in/azhar-rivaldi
 * Instagram : https://www.instagram.com/azhardvls_
 * Twitter : https://twitter.com/azharrvldi_
 * Youtube Channel : https://bit.ly/2PJMowZ
 */

data class ModelArticle(
        @SerializedName("source")
        var modelSource: ModelSource?,

        @SerializedName("author")
        var author: String = "",

        @SerializedName("title")
        var title: String = "",

        @SerializedName("description")
        var description: String = "",

        @SerializedName("url")
        var url: String = "",

        @SerializedName("urlToImage")
        var urlToImage: String = "",

        @SerializedName("publishedAt")
        var publishedAt: String = ""
) : Parcelable

data class ModelSource(
        @SerializedName("id")
        val id: String? = "",

        @SerializedName("name")
        val name: String? = ""
) : Parcelable
