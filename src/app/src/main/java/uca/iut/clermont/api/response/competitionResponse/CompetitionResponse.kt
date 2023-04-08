package uca.iut.clermont.api.response.competitionResponse

data class CompetitionResponse(
    val competitions: List<CompetitionResult>,
    val count: Int,
    val filters: Filters
)