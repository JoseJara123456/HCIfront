package com.example.myapplication.data


object UserSession {
    var idUsuario: String? = null
    var nombre: String? = null

    fun saveUserData(usuarioId: String, nombreUsuario: String) {

        idUsuario = usuarioId
        nombre = nombreUsuario
    }

    fun clearUserData() {
        idUsuario = null
        nombre = null
    }
}