package uca.iut.clermont.model

import java.util.Calendar

class Match(
    val id: Int,
    val idHomeTeam: Int,
    val idAwayTeam: Int,
    val date: Calendar,
    val status: String,
    val score: Score
)