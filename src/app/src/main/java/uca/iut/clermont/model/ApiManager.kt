package uca.iut.clermont.model

import AreaManager
import CompetitionsManager
import DataManager
import MatchesManager
import PeopleManager
import TeamsManager

class StubData : DataManager() {
    override val areaMgr: AreaManager = ApiAreaManager()
    override val peopleMgr: PeopleManager = ApiPeopleManager()
    override val matchesMgr: MatchesManager = ApiMatchesManager()
    override val competitionsMgr: CompetitionsManager = ApiCompetitionsManager()
    override val teamsMgr: TeamsManager = ApiTeamsManager()

    class ApiAreaManager : AreaManager {
        override fun getItemsByName(substring: String): List<Area> {
            TODO("Not yet implemented")
        }

        override fun getItems(): List<Area> {
            TODO("Not yet implemented")
        }

        override fun getItemById(id: Int): Area? {
            TODO("Not yet implemented")
        }

    }

    class ApiPeopleManager : PeopleManager {
        override fun getItemsByName(substring: String): List<Personne> {
            TODO("Not yet implemented")
        }

        override fun getItems(): List<Personne> {
            TODO("Not yet implemented")
        }

        override fun getItemById(id: Int): Personne? {
            TODO("Not yet implemented")
        }

    }

    class ApiMatchesManager : MatchesManager {
        override fun getItemsByName(substring: String): List<Match> {
            TODO("Not yet implemented")
        }

        override fun getItems(): List<Match> {
            TODO("Not yet implemented")
        }

        override fun getItemById(id: Int): Match? {
            TODO("Not yet implemented")
        }

    }

    class ApiCompetitionsManager : CompetitionsManager {
        override fun getItemsByName(substring: String): List<Competition> {
            TODO("Not yet implemented")
        }

        override fun getItems(): List<Competition> {
            TODO("Not yet implemented")
        }

        override fun getItemById(id: Int): Competition? {
            TODO("Not yet implemented")
        }

    }

    class ApiTeamsManager : TeamsManager {
        override fun getItemsByName(substring: String): List<Team> {
            TODO("Not yet implemented")
        }

        override fun getItems(): List<Team> {
            TODO("Not yet implemented")
        }

        override fun getItemById(id: Int): Team? {
            TODO("Not yet implemented")
        }

    }
}