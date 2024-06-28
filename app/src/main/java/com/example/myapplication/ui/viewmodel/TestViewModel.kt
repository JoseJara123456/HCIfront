package com.example.myapplication.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.model.LoginRequest
import com.example.myapplication.data.model.LoginResponse
import com.example.myapplication.data.repository.TestRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import com.example.myapplication.data.UserSession
import com.example.myapplication.data.model.TestsYPreguntasResponse




class TestViewModel : ViewModel() {

    var testsYPreguntas by mutableStateOf<List<TestsYPreguntasResponse.Test>?>(null)
    var errorMessage by mutableStateOf("")

    private val testRepository = TestRepository()

    fun obtenerTestsYPreguntasUsuario() {
        val idUsuario = UserSession.idUsuario?.toIntOrNull() ?: return
        viewModelScope.launch {
            try {
                val response = testRepository.obtenerTestsYPreguntasUsuario(idUsuario)
                testsYPreguntas = response.data
            } catch (e: HttpException) {
                errorMessage = e.message ?: "An error occurred"
            }
        }
    }
}
