package uca.iut.clermont.model

import java.util.Calendar

class Staff(
    id: Int,
    firstName: String,
    lastName: String,
    name: String,
    dateOfBirth: Calendar,
    nationality: String,
    contract: Contract
) : Personne(id, firstName, lastName, name, dateOfBirth, nationality, contract)