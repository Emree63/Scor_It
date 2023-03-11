package uca.iut.clermont.model

class Match(
    val id: Int,
    val idHomeTeam: Int,
    val idAwayTeam: Int,
    val status: String,
    val winner: String
) {
}