package com.lautarodev.cineradar.shows.local

import android.content.Context

object ShowsDataBaseProvider {

    lateinit var dbLocal: ShowsDataBase
        private set
    fun createDataBase(context: Context){
        dbLocal = ShowsDataBase.getInstance(context)
    }

}