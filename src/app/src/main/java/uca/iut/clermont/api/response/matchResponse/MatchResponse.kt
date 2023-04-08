package uca.iut.clermont.api.response.matchResponse

data class MatchResponse(
    val filters: Filters,
    val matches: List<MatchResult>,
    val resultSet: ResultSet
)