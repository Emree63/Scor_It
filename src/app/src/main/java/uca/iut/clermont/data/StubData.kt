package uca.iut.clermont.data

import AreaManager
import CompetitionsManager
import DataManager
import MatchesManager
import PeopleManager
import TeamsManager
import uca.iut.clermont.model.*

class StubData: DataManager() {
    override val areaMgr: AreaManager = StubAreaManager()
    override val peopleMgr: PeopleManager = StubPeopleManager()
    override val matchesMgr: MatchesManager = StubMatchesManager()
    override val competitionsMgr: CompetitionsManager = StubCompetitionsManager()
    override val teamsMgr: TeamsManager = StubTeamsManager()

    class StubAreaManager : AreaManager {
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

    class StubPeopleManager : PeopleManager {
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

    class StubMatchesManager : MatchesManager {
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

    class StubCompetitionsManager : CompetitionsManager {
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

    class StubTeamsManager : TeamsManager {
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