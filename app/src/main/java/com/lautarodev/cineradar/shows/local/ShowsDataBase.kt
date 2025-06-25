package com.lautarodev.cineradar.shows.local

import android.content.Context
import androidx.room.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@Database(entities = [ShowsLocal::class], version = 1 , exportSchema = false)
abstract class ShowsDataBase : RoomDatabase() {

    abstract fun showsDao(): IShowsDao

    companion object {
        @Volatile
        private var _instance: ShowsDataBase? = null


        fun getInstance(context: Context): ShowsDataBase {
            return _instance?: synchronized(this){
                _instance?: buildDataBase(context).also { _instance = it }
            }
        }


        private fun buildDataBase(context: Context) : ShowsDataBase{
            return Room.databaseBuilder(
                context.applicationContext, ShowsDataBase::class.java, "shows.db"
            ).fallbackToDestructiveMigration().build()
        }











//        private fun buildDataBase(context: Context): ShowsDataBase =
//            Room.databaseBuilder(context, ShowsDataBase::class.java, "shows_database")
//                .fallbackToDestructiveMigration()
//                .build()
//
//        suspend fun clean() = coroutineScope {
//            launch(Dispatchers.IO) {
//                getInstance().clearAllTables()
//            }
//        }
    }
}

