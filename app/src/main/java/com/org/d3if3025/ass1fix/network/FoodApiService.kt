package com.org.d3if3025.ass1fix.network

import com.org.d3if3025.ass1fix.Food
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://raw.githubusercontent.com/thessaroxana/foodie-json/main/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface FoodApiService {
    @GET("food.json")
    suspend fun getFood(): ArrayList<Food>
}

object FoodApi {
    val service: FoodApiService by lazy {
        retrofit.create(FoodApiService::class.java)
    }

    fun getFoodUrl(imageId: String): String {
        return "$BASE_URL$imageId.jpg"

    }
}
enum class ApiStatus { LOADING, SUCCESS, FAILED }
