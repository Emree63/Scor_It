package uca.iut.clermont.model

import java.util.Date

abstract class Personne(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val name: String,
    val dateOfBirth: Date,
    val nationality: String,
    val contract: Contract
)