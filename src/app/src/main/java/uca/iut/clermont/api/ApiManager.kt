package uca.iut.clermont.api

import AreaManager
import CompetitionsManager
import DataManager
import MatchesManager
import PeopleManager
import TeamsManager
import kotlinx.coroutines.coroutineScope
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uca.iut.clermont.model.*

val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl("https://api.football-data.org/v4/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val footballApi: FootballApi = retrofit.create(FootballApi::class.java)

class ApiManager : DataManager() {
    override val areaMgr: AreaManager = ApiAreaManager()
    override val peopleMgr: PeopleManager = ApiPeopleManager()
    override val matchesMgr: MatchesManager = ApiMatchesManager()
    override val competitionsMgr: CompetitionsManager = ApiCompetitionsManager()
    override val teamsMgr: TeamsManager = ApiTeamsManager()

    class ApiAreaManager : AreaManager {

        override suspend fun getItemsByName(substring: String): List<Area> = coroutineScope {
            val areas = footballApi.getAreas()
            return@coroutineScope areas.areas.filter { it.name.contains(substring) }
        }

        override suspend fun getItems(): List<Area> = coroutineScope {
            val areas = footballApi.getAreas()
            return@coroutineScope areas.areas
        }

        override suspend fun getItemById(id: Int): Area = coroutineScope {
            val area = footballApi.getArea(id)
            return@coroutineScope area
        }

    }

    class ApiPeopleManager : PeopleManager {

        override suspend fun getItems(): List<Personne> = listOf()

        override suspend fun getItemById(id: Int): Personne? = coroutineScope {
            val personne = footballApi.getPlayer(id)
            personne?.let {
                return@coroutineScope personne.toModel()
            }
            return@coroutineScope null
        }
    }

    class ApiMatchesManager : MatchesManager {

        override suspend fun getNbItemsByCompetition(id: Int): Int = coroutineScope {
            val matches = footballApi.getMatchesByCompetition(id)
            return@coroutineScope matches.matches.size
        }

        override suspend fun getItemsByCompetition(id: Int): List<Match> =
            coroutineScope {
                val matches = footballApi.getMatchesByCompetition(id)
                return@coroutineScope matches.matches.map { it.toModel() }
            }

        override suspend fun getItems(): List<Match> = coroutineScope {
            val matches = footballApi.getMatches()
            return@coroutineScope matches.matches.map { matchResult -> matchResult.toModel() }
        }

        override suspend fun getItemById(id: Int): Match = coroutineScope {
            val match = footballApi.getMatch(id)
            return@coroutineScope match.toModel()
        }

    }

    class ApiCompetitionsManager : CompetitionsManager {

        override suspend fun getItemsByName(substring: String): List<Competition> = coroutineScope {
            val competitons = footballApi.getCompetitions()
            return@coroutineScope competitons.competitions.map { competitionResult -> competitionResult.toModel() }
                .filter { it.name == substring }
        }

        override suspend fun getItems(): List<Competition> = coroutineScope {
            val competitons = footballApi.getCompetitions()
            return@coroutineScope competitons.competitions.map { competitionResult -> competitionResult.toModel() }
                .sortedBy { it.name }
        }

        override suspend fun getItemById(id: Int): Competition = coroutineScope {
            val competition = footballApi.getCompetition(id)
            return@coroutineScope competition.toModel()
        }

    }

    class ApiTeamsManager : TeamsManager {

        override fun getItemsByName(substring: String): List<Team> {
            TODO("Not yet implemented")
        }

        override suspend fun getItems(): List<Team> {
            TODO("Not yet implemented")
        }

        override suspend fun getItemById(id: Int): Team? {
            TODO("Not yet implemented")
        }

    }
}