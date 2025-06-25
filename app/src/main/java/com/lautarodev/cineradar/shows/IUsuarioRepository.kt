package com.lautarodev.cineradar.shows

interface IUsuarioRepository {

    suspend fun fetchUser() :Usuario
    suspend fun addSaved(id: String)
    suspend fun removeSaved(id: String)
    suspend fun getSaved(): List<String>


    suspend fun addVisto(id: String)
    suspend fun removeVisto(id: String)
    suspend fun getVistos(): List<String>
}