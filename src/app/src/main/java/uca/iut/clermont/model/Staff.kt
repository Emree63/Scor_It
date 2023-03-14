package uca.iut.clermont.model

import java.util.Date

class Staff(
    id: Int,
    firstName: String,
    lastName: String,
    name: String,
    dateOfBirth: Date,
    nationality: String,
    contract: Contract
) : Personne(id, firstName, lastName, name, dateOfBirth, nationality, contract)