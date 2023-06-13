package com.org.d3if3025.ass1fix.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://raw.githubusercontent.com/thessaroxana/foodie-json/main/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface FoodApiService {
    @GET("food.json")
    suspend fun getFood(): String
}

object FoodApi {
    val service: FoodApiService by lazy {
        retrofit.create(FoodApiService::class.java)
    }
}