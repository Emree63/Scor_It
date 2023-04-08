package uca.iut.clermont.api

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import uca.iut.clermont.api.response.competitionResponse.CompetitionResponse
import uca.iut.clermont.api.response.matchResponse.MatchResponse
import uca.iut.clermont.model.Area
import uca.iut.clermont.model.PlayerResponse

interface FootballApi {

    @GET("areas")
    suspend fun getAreas(): List<Area>

    @Headers("X-Auth-Token: 7814ffe5b0314b5291a287d32a178e57")
    @GET("persons/{id}")
    suspend fun getPlayer(@Path("id") playerId: Int): PlayerResponse

    @Headers("X-Auth-Token: 7814ffe5b0314b5291a287d32a178e57")
    @GET("persons")
    suspend fun getPlayers(): List<PlayerResponse>

    @Headers("X-Auth-Token: 7814ffe5b0314b5291a287d32a178e57")
    @GET("competitions")
    suspend fun getCompetitions(): CompetitionResponse

    @Headers("X-Auth-Token: 7814ffe5b0314b5291a287d32a178e57")
    @GET("matches")
    suspend fun getMatches(): MatchResponse
}
