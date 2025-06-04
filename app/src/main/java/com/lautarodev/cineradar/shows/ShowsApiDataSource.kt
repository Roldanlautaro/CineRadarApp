package com.lautarodev.cineradar.shows

import android.util.Log
import okhttp3.OkHttpClient
import okio.IOException
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ShowsApiDataSource : ICineRadarShowsSource {

    private val TAG = "ShowsApp"

    override suspend fun getShowsList(search : String): List<shows> {
        Log.d(TAG, "ShowsApiDataSource.getShowsList")

        return try {
            Log.d(TAG, "ShowsApiDataSource.getShowsList Search: $search")
            val shows = RetrofitInstance.showsApi.getShowsSearch(search)
            Log.d(TAG, "ShowsApiDataSource.getShowsList Result: ${shows.size}")
            return shows

        }catch (e : HttpException){
            Log.e(TAG,"Error de HTTP : ${e.code()} ${e.message()}")
            emptyList()
        }catch (e: IOException){
            Log.e(TAG,"Error de Network : ${e.localizedMessage}")
            emptyList()
        }catch (e : Exception){
            Log.e(TAG,"Error desconocido : ${e.localizedMessage}")
            emptyList()
        }
    }

    override suspend fun getShowById(id: String): shows {
        Log.d("id", id)
        return RetrofitInstance.showsApi.getShow(id)
    }

    override suspend fun getAllCienciaFiccion(): List<shows> {
        val response: CineRadarResult = RetrofitInstance.showsApi.getAllCienciaFiccion()
        return response.shows

    }
}