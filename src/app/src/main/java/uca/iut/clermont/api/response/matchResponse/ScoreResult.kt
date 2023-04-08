package uca.iut.clermont.api.response.matchResponse

import uca.iut.clermont.model.Score

data class ScoreResult(
    val duration: String,
    val fullTime: Time,
    val halfTime: Time,
    val winner: String?
){
    fun toModel() = Score(
        fullTime.home,
        fullTime.away,
        winner
    )
}