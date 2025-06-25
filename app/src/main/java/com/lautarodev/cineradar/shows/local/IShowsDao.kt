package com.lautarodev.cineradar.shows.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface IShowsDao {

    @Query("SELECT * FROM shows")
    suspend fun  getAll(): List<ShowsLocal>

    @Query("SELECT * FROM shows WHERE id = :id LIMIT 1")
    suspend fun finById(id: String): ShowsLocal

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg shows: ShowsLocal)

    @Delete
    suspend fun delete(shows: ShowsLocal)

}