package com.lautarodev.cineradar.shows

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class UsuarioDataSource {

    val db = FirebaseFirestore.getInstance()
    var email : String? = null

    suspend fun getUser(): Usuario{

        if(email == null){
            email = FirebaseAuth.getInstance().currentUser?.email.toString()
        }

        var response = db.collection("Usuarios").document(email.toString()).get().await()

        if (response == null){
            var usuario  = Usuario(email!!)
            db.collection("Usuarios").document(email!!).set(usuario)
            return usuario
        }else{
            return response.toObject(Usuario::class.java)!!
        }

    }

    suspend fun getSaved() : List<String> {
        val usuario = getUser()

        return usuario.guardados
    }

    suspend fun getVistos() : List<String> {
        val usuario = getUser()

        return usuario.vistos
    }

    suspend fun agregarGuardado(id: String){
        var usuario = getUser()
        usuario.guardados.add(id)
        FirebaseFirestore.getInstance().collection("Usuarios").document(email.toString()).set(usuario)
    }

    suspend fun agregarVistos(id: String){
        var usuario = getUser()
        usuario.vistos.add(id)
        FirebaseFirestore.getInstance().collection("Usuarios").document(email.toString()).set(usuario)
    }

    suspend fun eliminarGuardado(id:String){
        var usuario = getUser()
        usuario.guardados.remove(id)
        FirebaseFirestore.getInstance().collection("Usuarios").document(email.toString()).set(usuario)

    }

    suspend fun eliminarVisto(id:String){
        var usuario = getUser()
        usuario.vistos.remove(id)
        FirebaseFirestore.getInstance().collection("Usuarios").document(email.toString()).set(usuario)

    }

}