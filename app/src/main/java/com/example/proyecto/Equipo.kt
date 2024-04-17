package com.example.proyecto

data class Equipo(
    val id: Int,
    val nombre: String,
    val apodo: String,
    val estadio: String,
    val escudo: String,
    val pais: paises
)

enum class paises{
    Argentina, Brasil, Inglaterra, Espana, Alemania
}