package com.lautarodev.cineradar.shows

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.lautarodev.cineradar.shows.local.ShowsDataBase
import com.lautarodev.cineradar.shows.local.ShowsDataBaseProvider
import com.lautarodev.cineradar.shows.local.toLocal
import com.lautarodev.cineradar.shows.local.toShows
import okio.IOException
import retrofit2.HttpException
import kotlinx.coroutines.tasks.await

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

        val dblocal = ShowsDataBaseProvider.dbLocal


        // Local
        var showsLocal = dblocal.showsDao().finById(id)
        if (showsLocal != null) {
            Log.d("SHOWSDB", "encontrado en room")
            return showsLocal.toShows()

        }
        else{
            var show = RetrofitInstance.showsApi.getShow(id)
            dblocal.showsDao().insert(show.toLocal())

            return show
        }

    }


    // Pantalla main

    override suspend fun getAllCienciaFiccion(): List<shows> {
        val response: CineRadarResult = RetrofitInstance.showsApi.getAllCienciaFiccion()
        return response.shows

    }

    override suspend fun getAllMejoresPeliculasNETFLIX(): List<shows> {
        val response: CineRadarResult = RetrofitInstance.showsApi.getAllMejoresPeliculasNETFLIX()
        return response.shows
    }

    override suspend fun getAllMejoresPeliculasCienciaFiccionDISNEY(): List<shows> {
        val response: CineRadarResult = RetrofitInstance.showsApi.getAllMejoresPeliculasCienciaFiccionDISNEY()
        return response.shows
    }

    override suspend fun getAllMejoresPeliculasTerrorHBO(): List<shows> {
        val response: CineRadarResult = RetrofitInstance.showsApi.getAllMejoresPeliculasTerrorHBO()
        return response.shows
    }

    // Pantalla popular

    override suspend fun getMejoresSeries(): List<shows> {
        val response: CineRadarResult = RetrofitInstance.showsApi.getMejoresSeries()
        return response.shows
    }

    override suspend fun getMejoresPeliculasDelAnio(): List<shows> {
        val response: CineRadarResult = RetrofitInstance.showsApi.getMejoresPeliculasDelAnio()
        return response.shows
    }

    override suspend fun getMejoresSeriesDeLosUltimosAnios(): List<shows> {
        val response: CineRadarResult = RetrofitInstance.showsApi.getMejoresSeriesDeLosUltimosAnios()
        return response.shows
    }

    override suspend fun getMejoresPeliculas(): List<shows> {
        val response: CineRadarResult = RetrofitInstance.showsApi.getMejoresPeliculas()
        return response.shows
    }
}