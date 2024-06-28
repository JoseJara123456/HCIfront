package com.example.myapplication.data.model

data class TestsYPreguntasResponse(
    val message: String,
    val status: Int,
    val data: List<Test>
) {
    data class Test(
        val descripcion: String,
        val especialista_id: Int,
        val estudiante_id: Int,
        val fecha_asignacion: String,
        val preguntas: List<Pregunta>,
        val testid: Int,
        val titulo: String
    )

    data class Pregunta(
        val preguntaid: Int,
        val testid: Int,
        val descripcion: String
    )
}