package com.example.myapplication.navigation

sealed class AppScreen(val route: String){
    object HomeScreen: AppScreen("home")
    object MainScreen : AppScreen("main_screen")
    object PacienteScreen : AppScreen("paciente")
    object EspecialistaScreen : AppScreen("especialista")
    object RealizarTest : AppScreen("test")
}
