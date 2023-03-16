package uca.iut.clermont.model

import java.util.*

class Player(
    id: Int,
    firstName: String,
    lastName: String,
    name: String,
    dateOfBirth: Calendar,
    nationality: String,
    contract: Contract,
    val position: String,
    val shirtNumber: Int
) : Personne(id, firstName, lastName, name, dateOfBirth, nationality, contract)