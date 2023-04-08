package uca.iut.clermont.api.response.competitionResponse

import uca.iut.clermont.model.Area
import uca.iut.clermont.model.Competition

class CompetitionResult(
    val id: Int,
    val name: String,
    val code: String,
    val type: String,
    val emblem: String,
    val currentSeason: CurrentSeason,
    val area: Area
) {
    fun toModel() = Competition(
        id,
        name,
        code,
        type,
        emblem,
        currentSeason.toModel(),
        area
    )
}