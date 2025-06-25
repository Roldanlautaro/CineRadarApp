package com.lautarodev.cineradar.shows

class UsuarioRepository (val usuarioDataSource: UsuarioDataSource = UsuarioDataSource()) : IUsuarioRepository {


    override suspend fun fetchUser(): Usuario {
        return usuarioDataSource.getUser()
    }

    override suspend fun addSaved(id: String) {
        return usuarioDataSource.agregarGuardado(id)
    }

    override suspend fun removeSaved(id: String) {
        return usuarioDataSource.eliminarGuardado(id)
    }

    override suspend fun getSaved(): List<String> {
        return usuarioDataSource.getSaved()
    }

    override suspend fun addVisto(id: String) {
        return usuarioDataSource.agregarVistos(id)
    }

    override suspend fun removeVisto(id: String) {
        return usuarioDataSource.eliminarVisto(id)
    }

    override suspend fun getVistos(): List<String> {
        return usuarioDataSource.getVistos()
    }
}