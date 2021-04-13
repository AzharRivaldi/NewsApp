package com.azhar.newsapp.networking

import com.azhar.newsapp.model.ModelNews
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Azhar Rivaldi on 10-04-2021
 * Github : https://github.com/AzharRivaldi
 * Linkedin : https://www.linkedin.com/in/azhar-rivaldi
 * Instagram : https://www.instagram.com/azhardvls_
 * Twitter : https://twitter.com/azharrvldi_
 * Youtube Channel : https://bit.ly/2PJMowZ
 */

interface ApiInterface {
    @GET("top-headlines")
    fun getHeadlines(
            @Query("country") country: String?,
            @Query("apiKey") apiKey: String?
    ): Call<ModelNews>

    @GET("top-headlines")
    fun getSports(
            @Query("country") country: String?,
            @Query("category") category: String?,
            @Query("apiKey") apiKey: String?
    ): Call<ModelNews>

    @GET("top-headlines")
    fun getTechnology(
            @Query("country") country: String?,
            @Query("category") category: String?,
            @Query("apiKey") apiKey: String?
    ): Call<ModelNews>

    @GET("top-headlines")
    fun getBusiness(
            @Query("country") country: String?,
            @Query("category") category: String?,
            @Query("apiKey") apiKey: String?
    ): Call<ModelNews>

    @GET("top-headlines")
    fun getHealth(
            @Query("country") country: String?,
            @Query("category") category: String?,
            @Query("apiKey") apiKey: String?
    ): Call<ModelNews>

    @GET("top-headlines")
    fun getEntertainment(
            @Query("country") country: String?,
            @Query("category") category: String?,
            @Query("apiKey") apiKey: String?
    ): Call<ModelNews>

    @GET("everything")
    fun getNewsSearch(
            @Query("q") keyword: String?,
            @Query("language") language: String?,
            @Query("apiKey") apiKey: String?
    ): Call<ModelNews>

}