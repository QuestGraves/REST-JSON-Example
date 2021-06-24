package com.keltica.rest_json_example.api

import com.keltica.rest_json_example.util.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ExampleApi by lazy {
        retrofit.create(ExampleApi::class.java)
    }
}