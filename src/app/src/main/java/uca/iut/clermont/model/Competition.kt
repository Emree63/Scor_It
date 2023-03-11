package uca.iut.clermont.model

class Competition(
    val id: Int,
    val name: String,
    val code: String,
    val type: String,
    val emblem: String,
    val currentSeason: season,
    val area: Area
) {
}