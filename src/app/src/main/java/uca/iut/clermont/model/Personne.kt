package uca.iut.clermont.model

import java.util.Calendar

abstract class Personne(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val name: String,
    val dateOfBirth: Calendar,
    val nationality: String,
    val contract: Contract
)