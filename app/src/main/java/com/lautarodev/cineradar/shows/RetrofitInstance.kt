package com.lautarodev.cineradar.shows

import com.lautarodev.cineradar.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val BASE_URL = "https://streaming-availability.p.rapidapi.com/"
    private val apiKey = BuildConfig.API_KEY

    private  val client by lazy {
        OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("X-RapidAPI-Key", apiKey)
                    .build()
                chain.proceed(request)
            }
            .build()
    }

    private  val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val showsApi : IShowsAPI by lazy {
        retrofit.create(IShowsAPI::class.java)
    }

}