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
import java.text.SimpleDateFormat
import java.util.*

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

        override fun getItemsByName(substring: String): List<Area> {
            TODO("Not yet implemented")
        }

        override suspend fun getItems(): List<Area> {
            TODO("Not yet implemented")
        }

        override suspend fun getItemById(id: Int): Area? {
            TODO("Not yet implemented")
        }

    }

    class ApiPeopleManager : PeopleManager {

        override fun getItemsByName(substring: String): List<Personne> {
            TODO("Not yet implemented")
        }

        override suspend fun getItems(): List<Personne> {
            TODO("Not yet implemented")
        }

        override suspend fun getItemById(id: Int): Personne? = coroutineScope {
            val personne = footballApi.getPlayer(id)
            personne?.let {
                return@coroutineScope personne.toModel()
            }
            return@coroutineScope null
        }
    }

    class ApiMatchesManager : MatchesManager {
        override fun getNbItemsByCompetition(substring: String): Int {
            TODO("Not yet implemented")
        }

        override fun getItemsByCompetition(substring: String): List<Match> {
            TODO("Not yet implemented")
        }

        override suspend fun getItems(): List<Match> = coroutineScope {
            val matches = footballApi.getMatches()
            return@coroutineScope matches.matches.map { matchResult -> matchResult.toModel() }
        }

        override suspend fun getItemById(id: Int): Match? {
            TODO("Not yet implemented")
        }

    }

    class ApiCompetitionsManager : CompetitionsManager {
        override fun getItemsByName(substring: String): List<Competition> {
            TODO("Not yet implemented")
        }

        override suspend fun getItems(): List<Competition> = coroutineScope {
            val competitons = footballApi.getCompetitions()
            return@coroutineScope competitons.competitions.map { competitionResult -> competitionResult.toModel()  }.sortedBy { it.name }
        }

        override suspend fun getItemById(id: Int): Competition? {
            TODO("Not yet implemented")
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