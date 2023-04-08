package uca.iut.clermont.api.response.matchResponse

import uca.iut.clermont.api.response.competitionResponse.CurrentSeason
import uca.iut.clermont.model.Area
import uca.iut.clermont.model.Match
import java.text.SimpleDateFormat
import java.util.*

class MatchResult(
    val id: Int,
    val homeTeam: TeamResult,
    val awayTeam: TeamResult,
    val utcDate: String,
    val status: String,
    val score: ScoreResult,
    val season: CurrentSeason,
    val area: Area,
    val competition: MatchCompetitionResult
) {
    fun toModel() = Match(
        id,
        homeTeam.toModel(),
        awayTeam.toModel(),
        Calendar.getInstance().apply {
            time = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US).parse(utcDate)
        },
        status,
        score.toModel(),
        competition.toModel(season, area)

    )
}