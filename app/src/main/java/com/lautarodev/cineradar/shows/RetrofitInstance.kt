package com.lautarodev.cineradar.shows

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

     private val BASE_URL = "https://streaming-availability.p.rapidapi.com/"

    private  val client by lazy {
        OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("X-RapidAPI-Key", "2fc3529d10msh0013db6722847a1p14e8d3jsn579ae3d2a078")
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