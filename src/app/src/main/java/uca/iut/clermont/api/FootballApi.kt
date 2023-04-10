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

    // Area

    @Headers("X-Auth-Token: 7814ffe5b0314b5291a287d32a178e57")
    @GET("areas/{id}")
    suspend fun getArea(@Path("id") id: Int): Area

    @Headers("X-Auth-Token: 7814ffe5b0314b5291a287d32a178e57")
    @GET("areas")
    suspend fun getAreas(): AreaResponse

    // Person

    @Headers("X-Auth-Token: 7814ffe5b0314b5291a287d32a178e57")
    @GET("persons/{id}")
    suspend fun getPlayer(@Path("id") playerId: Int): PlayerResponse

    // Competition

    @Headers("X-Auth-Token: 621ef06e148542f98b4993a5442421eb")
    @GET("competitions")
    suspend fun getCompetitions(): CompetitionResponse

    @Headers("X-Auth-Token: 8f51b43de0444026bd3ec3484f082575")
    @GET("competitions/{id}")
    suspend fun getCompetition(@Path("id") id: Int): CompetitionResult

    // Team
    @Headers("X-Auth-Token: 9983c8c887464274bed01ff046775bed")
    @GET("teams?limit=1000")
    suspend fun getTeams(): CompetitionResponse

    @Headers("X-Auth-Token: 84c47f4211244a0d9b3cb9376e00f4aa")
    @GET("competitions/{id}/teams")
    suspend fun getTeamsByCompetition(): CompetitionResponse

    @Headers("X-Auth-Token: 9983c8c887464274bed01ff046775bed")
    @GET("teams/{id}")
    suspend fun getTeam(): CompetitionResponse

    // Match

    @Headers("X-Auth-Token: 7814ffe5b0314b5291a287d32a178e57")
    @GET("matches")
    suspend fun getMatches(): MatchResponse

    @Headers("X-Auth-Token: 621ef06e148542f98b4993a5442421eb")
    @GET("matches/{id}")
    suspend fun getMatch(@Path("id") id: Int): MatchResult

    @Headers("X-Auth-Token: b002ff114afa41a590e2baef63d8c689")
    @GET("competitions/{id}/matches")
    suspend fun getMatchesByCompetition(@Path("id") id: Int): MatchResponse

}
