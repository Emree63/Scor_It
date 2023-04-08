package uca.iut.clermont.api.response.matchResponse

import uca.iut.clermont.api.response.competitionResponse.CurrentSeason
import uca.iut.clermont.model.Area
import uca.iut.clermont.model.Competition

class MatchCompetitionResult(
    val id: Int,
    val name: String,
    val code: String,
    val type: String,
    val emblem: String
) {
    fun toModel(season: CurrentSeason, area: Area) = Competition(
        id,
        name,
        code,
        type,
        emblem,
        season.toModel(),
        area
    )
}