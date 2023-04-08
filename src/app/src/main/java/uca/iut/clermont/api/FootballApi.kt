package uca.iut.clermont.api

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import uca.iut.clermont.api.response.areaResponse.AreaResponse
import uca.iut.clermont.api.response.competitionResponse.CompetitionResponse
import uca.iut.clermont.api.response.competitionResponse.CompetitionResult
import uca.iut.clermont.api.response.matchResponse.MatchResponse
import uca.iut.clermont.api.response.matchResponse.MatchResult
import uca.iut.clermont.model.Area
import uca.iut.clermont.model.PlayerResponse

interface FootballApi {

    @Headers("X-Auth-Token: 7814ffe5b0314b5291a287d32a178e57")
    @GET("areas/{id}")
    suspend fun getArea(@Path("id") id: Int): Area

    @Headers("X-Auth-Token: 7814ffe5b0314b5291a287d32a178e57")
    @GET("areas")
    suspend fun getAreas(): AreaResponse

    @Headers("X-Auth-Token: 7814ffe5b0314b5291a287d32a178e57")
    @GET("persons/{id}")
    suspend fun getPlayer(@Path("id") playerId: Int): PlayerResponse

    @Headers("X-Auth-Token: 7814ffe5b0314b5291a287d32a178e57")
    @GET("competitions")
    suspend fun getCompetitions(): CompetitionResponse

    @Headers("X-Auth-Token: 7814ffe5b0314b5291a287d32a178e57")
    @GET("competitions/{id}")
    suspend fun getCompetition(@Path("id") id: Int): CompetitionResult

    @Headers("X-Auth-Token: 7814ffe5b0314b5291a287d32a178e57")
    @GET("matches")
    suspend fun getMatches(): MatchResponse

    @Headers("X-Auth-Token: 7814ffe5b0314b5291a287d32a178e57")
    @GET("matches/{id}")
    suspend fun getMatch(@Path("id") id: Int): MatchResult

    @Headers("X-Auth-Token: 7814ffe5b0314b5291a287d32a178e57")
    @GET("matches/{id}/matches")
    suspend fun getMatchesByCompetition(@Path("id") id: Int): MatchResponse

}
