package uca.iut.clermont.data

import AreaManager
import CompetitionsManager
import DataManager
import MatchesManager
import PeopleManager
import TeamsManager
import uca.iut.clermont.model.*
import java.util.*

class StubData: DataManager() {
    override val areaMgr: AreaManager = StubAreaManager(this)
    override val peopleMgr: PeopleManager = StubPeopleManager(this)
    override val matchesMgr: MatchesManager = StubMatchesManager()
    override val competitionsMgr: CompetitionsManager = StubCompetitionsManager()
    override val teamsMgr: TeamsManager = StubTeamsManager(this)

    private val areaList = listOf(
        Area(1, "France", "FRA", "https://crests.football-data.org/773.svg", "Europe"),
        Area(2, "Spain", "ESP", "https://crests.football-data.org/760.svg", "Europe"),
        Area(3, "Brazil", "BRA", "https://crests.football-data.org/764.svg", "South America"),
        Area(4, "Mexico", "Mex", "https://crests.football-data.org/mexico.svg", "North America"),
        Area(5, "Australia", "AUS", "https://australie-voyage.fr/wp-content/uploads/2020/08/Drapeau-australien.jpg", "Oceania")
    )

    private val peopleList = listOf(
        Player(1, "Lionel", "Messi", "L. Messi", Date(1987, 6, 24), "Argentina", Contract(Date(2020, 6, 1), Date(2025, 6, 1)), "Forward", 10),
        Player(2, "Cristiano", "Ronaldo", "C. Ronaldo", Date(1985, 2, 5), "Portugal", Contract(Date(2020, 7, 1), Date(2024, 7, 1)), "Forward", 7),
        Player(3, "Neymar", "Jr", "Neymar", Date(1992, 2, 5), "Brazil", Contract(Date(2021, 1, 1), Date(2026, 1, 1)), "Forward", 10),
        Player(4, "Kylian", "Mbappe", "K. Mbappe", Date(1998, 12, 20), "France", Contract(Date(2022, 1, 1), Date(2027, 1, 1)), "Forward", 7),
        Player(5, "Mohamed", "Salah", "M. Salah", Date(1992, 6, 15), "Egypt", Contract(Date(2021, 7, 1), Date(2025, 7, 1)), "Forward", 11),
        Player(6, "Kevin", "De Bruyne", "K. De Bruyne", Date(1991, 6, 28), "Belgium", Contract(Date(2021, 8, 1), Date(2026, 8, 1)), "Midfielder", 17),
        Player(7, "Robert", "Lewandowski", "R. Lewandowski", Date(1988, 8, 21), "Poland", Contract(Date(2021, 1, 1), Date(2024, 1, 1)), "Forward", 9),
        Player(8, "Sadio", "Mane", "S. Mane", Date(1992, 4, 10), "Senegal", Contract(Date(2022, 1, 1), Date(2026, 1, 1)), "Forward", 10),
        Player(9, "Virgil", "Van Dijk", "V. Van Dijk", Date(1991, 7, 8), "Netherlands", Contract(Date(2023, 1, 1), Date(2026, 1, 1)), "Defender", 4),
        Player(10, "Luka", "Modric", "L. Modric", Date(1985, 9, 9), "Croatia", Contract(Date(2020, 6, 1), Date(2022, 6, 1)), "Midfielder", 10),
        Player(11, "Harry", "Kane", "H. Kane", Date(1993, 7, 28), "England", Contract(Date(2021, 7, 1), Date(2025, 7, 1)), "Forward", 10),
        Player(12, "Sergio", "Aguero", "S. Aguero", Date(1988, 6, 2), "Argentina", Contract(Date(2021, 6, 1), Date(2023, 6, 1)), "Forward", 10),
        Player(13, "Eden", "Hazard", "E. Hazard", Date(1991, 1, 7), "Belgium", Contract(Date(2022, 1, 1), Date(2027, 1, 1)), "Forward", 7),
        Coach(14, "Pep", "Guardiola", "P. Guardiola", Date(1971, 1, 18), "Spain", Contract(Date(2020, 6, 1), Date(2023, 6, 1))),
        Coach(15, "Jurgen", "Klopp", "J. Klopp", Date(1967, 6, 16), "Germany", Contract(Date(2020, 7, 1), Date(2024, 7, 1))),
        Staff(16, "Jorge", "Desio", "J. Desio", Date(1966, 1, 1), "Argentina", Contract(Date(2020, 6, 1), Date(2023, 6, 1))),
        Staff(17, "Craig", "Mawson", "C. Mawson", Date(1973, 8, 22), "England", Contract(Date(2020, 7, 1), Date(2024, 7, 1)))
    )
    private val teamList = listOf(
        Team(
            1,
            "Paris Saint-Germain FC",
            "PSG",
            "https://crests.football-data.org/524.svg",
            "24 Rue du Commandant Guilbaud, 75016 Paris, France",
            "https://www.psg.fr/",
            "1970",
            "Navy / Red",
            areaList[0],
            "Parc des Princes",
            peopleList[0] as Coach,
            listOf(peopleList[2] as Staff),
            listOf(peopleList[0] as Player, peopleList[3] as Player, peopleList[11] as Player)
        ),
        Team(
            2,
            "FC Barcelona",
            "BAR",
            "https://crests.football-data.org/81.svg",
            "Carrer d'Aristides Maillol, s/n, 08028 Barcelona, Spain",
            "https://www.fcbarcelona.com/",
            "1899",
            "Blue / Red",
            areaList[3],
            "Camp Nou",
            peopleList[0] as Coach,
            listOf(peopleList[2] as Staff),
            listOf(peopleList[0] as Player, peopleList[5] as Player, peopleList[9] as Player)
        ),
        Team(
            3,
            "Liverpool FC",
            "LIV",
            "https://crests.football-data.org/64.svg",
            "Anfield Road, Liverpool L4 0TH, United Kingdom",
            "https://www.liverpoolfc.com/",
            "1892",
            "Red",
            areaList[2],
            "Anfield",
            peopleList[1] as Coach,
            listOf(peopleList[3] as Staff),
            listOf(peopleList[7] as Player, peopleList[8] as Player, peopleList[10] as Player)
        )
    )


    class StubAreaManager(private val parent: StubData) : AreaManager {
        override fun getItemsByName(substring: String) =
            parent.areaList.filter { it.name.contains(substring, ignoreCase = true) }

        override fun getItems(): List<Area> = parent.areaList

        override fun getItemById(id: Int) = parent.areaList.find { it.id == id }

    }

    class StubPeopleManager(private val parent: StubData) : PeopleManager {
        override fun getItemsByName(substring: String) =
            parent.peopleList.filter { it.name.contains(substring, ignoreCase = true) }

        override fun getItems() = parent.peopleList

        override fun getItemById(id: Int) = parent.peopleList.find { it.id == id }
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

    class StubTeamsManager(private val parent: StubData) : TeamsManager {
        override fun getItemsByName(substring: String) =
            parent.teamList.filter { it.name.contains(substring, ignoreCase = true) }

        override fun getItems() = parent.teamList

        override fun getItemById(id: Int) = parent.teamList.find { it.id == id }

    }
}