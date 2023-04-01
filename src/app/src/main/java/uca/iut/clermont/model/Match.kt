package uca.iut.clermont.model

import java.util.Calendar

class Match(
    val id: Int,
    val homeTeam: Team,
    val awayTeam: Team,
    val date: Calendar,
    val status: String,
    val score: Score,
    val competition: Competition
)