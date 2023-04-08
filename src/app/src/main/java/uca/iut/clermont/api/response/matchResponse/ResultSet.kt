package uca.iut.clermont.api.response.matchResponse

data class ResultSet(
    val competitions: String,
    val count: Int,
    val first: String,
    val last: String,
    val played: Int
)