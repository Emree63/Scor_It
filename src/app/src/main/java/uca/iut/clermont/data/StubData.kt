package uca.iut.clermont.data

import AreaManager
import CompetitionsManager
import DataManager
import MatchesManager
import PeopleManager
import TeamsManager
import uca.iut.clermont.model.*
import java.util.*

class StubData : DataManager() {
    override val areaMgr: AreaManager = StubAreaManager(this)
    override val peopleMgr: PeopleManager = StubPeopleManager(this)
    override val matchesMgr: MatchesManager = StubMatchesManager(this)
    override val competitionsMgr: CompetitionsManager = StubCompetitionsManager(this)
    override val teamsMgr: TeamsManager = StubTeamsManager(this)

    private val areaList = listOf(
        Area(1, "France", "FRA", "https://crests.football-data.org/773.svg", "Europe"),
        Area(2, "Spain", "ESP", "https://crests.football-data.org/760.svg", "Europe"),
        Area(3, "Brazil", "BRA", "https://crests.football-data.org/764.svg", "South America"),
        Area(4, "Mexico", "Mex", "https://crests.football-data.org/mexico.svg", "North America"),
        Area(
            5,
            "Australia",
            "AUS",
            "https://australie-voyage.fr/wp-content/uploads/2020/08/Drapeau-australien.jpg",
            "Oceania"
        )
    )

    private val peopleList = listOf(
        Player(
            1,
            "Lionel",
            "Messi",
            "L. Messi",
            Calendar.getInstance().apply { set(1987, 6, 24) },
            "Argentina",
            Contract(
                Calendar.getInstance().apply { set(2020, 6, 1) },
                Calendar.getInstance().apply { set(2025, 6, 1) }),
            "Forward",
            10
        ),
        Player(
            2,
            "Cristiano",
            "Ronaldo",
            "C. Ronaldo",
            Calendar.getInstance().apply { set(1985, 2, 5) },
            "Portugal",
            Contract(
                Calendar.getInstance().apply { set(2020, 7, 1) },
                Calendar.getInstance().apply { set(2024, 7, 1) }),
            "Forward",
            7
        ),
        Player(
            3,
            "Neymar",
            "Jr",
            "Neymar",
            Calendar.getInstance().apply { set(1992, 2, 5) },
            "Brazil",
            Contract(
                Calendar.getInstance().apply { set(2021, 1, 1) },
                Calendar.getInstance().apply { set(2026, 1, 1) }),
            "Forward",
            10
        ),
        Player(
            4,
            "Kylian",
            "Mbappe",
            "K. Mbappe",
            Calendar.getInstance().apply { set(1998, 12, 20) },
            "France",
            Contract(
                Calendar.getInstance().apply { set(2022, 1, 1) },
                Calendar.getInstance().apply { set(2027, 1, 1) }),
            "Forward",
            7
        ),
        Player(
            5,
            "Mohamed",
            "Salah",
            "M. Salah",
            Calendar.getInstance().apply { set(1992, 6, 15) },
            "Egypt",
            Contract(
                Calendar.getInstance().apply { set(2021, 7, 1) },
                Calendar.getInstance().apply { set(2025, 7, 1) }),
            "Forward",
            11
        ),
        Player(
            6,
            "Kevin",
            "De Bruyne",
            "K. De Bruyne",
            Calendar.getInstance().apply { set(1991, 6, 28) },
            "Belgium",
            Contract(
                Calendar.getInstance().apply { set(2021, 8, 1) },
                Calendar.getInstance().apply { set(2026, 8, 1) }),
            "Midfielder",
            17
        ),
        Player(
            7,
            "Robert",
            "Lewandowski",
            "R. Lewandowski",
            Calendar.getInstance().apply { set(1988, 8, 21) },
            "Poland",
            Contract(
                Calendar.getInstance().apply { set(2021, 1, 1) },
                Calendar.getInstance().apply { set(2024, 1, 1) }),
            "Forward",
            9
        ),
        Player(
            8,
            "Sadio",
            "Mane",
            "S. Mane",
            Calendar.getInstance().apply { set(1992, 4, 10) },
            "Senegal",
            Contract(
                Calendar.getInstance().apply { set(2022, 1, 1) },
                Calendar.getInstance().apply { set(2026, 1, 1) }),
            "Forward",
            10
        ),
        Player(
            9,
            "Virgil",
            "Van Dijk",
            "V. Van Dijk",
            Calendar.getInstance().apply { set(1991, 7, 8) },
            "Netherlands",
            Contract(
                Calendar.getInstance().apply { set(2023, 1, 1) },
                Calendar.getInstance().apply { set(2026, 1, 1) }),
            "Defender",
            4
        ),
        Player(
            10,
            "Luka",
            "Modric",
            "L. Modric",
            Calendar.getInstance().apply { set(1985, 9, 9) },
            "Croatia",
            Contract(
                Calendar.getInstance().apply { set(2020, 6, 1) },
                Calendar.getInstance().apply { set(2022, 6, 1) }),
            "Midfielder",
            10
        ),
        Player(
            11,
            "Harry",
            "Kane",
            "H. Kane",
            Calendar.getInstance().apply { set(1993, 7, 28) },
            "England",
            Contract(
                Calendar.getInstance().apply { set(2021, 7, 1) },
                Calendar.getInstance().apply { set(2025, 7, 1) }),
            "Forward",
            10
        ),
        Player(
            12,
            "Sergio",
            "Aguero",
            "S. Aguero",
            Calendar.getInstance().apply { set(1988, 6, 2) },
            "Argentina",
            Contract(
                Calendar.getInstance().apply { set(2021, 6, 1) },
                Calendar.getInstance().apply { set(2023, 6, 1) }),
            "Forward",
            10
        ),
        Player(
            13,
            "Eden",
            "Hazard",
            "E. Hazard",
            Calendar.getInstance().apply { set(1991, 1, 7) },
            "Belgium",
            Contract(
                Calendar.getInstance().apply { set(2022, 1, 1) },
                Calendar.getInstance().apply { set(2027, 1, 1) }),
            "Forward",
            7
        ),
        Coach(
            14,
            "Pep",
            "Guardiola",
            "P. Guardiola",
            Calendar.getInstance().apply { set(1971, 1, 18) },
            "Spain",
            Contract(
                Calendar.getInstance().apply { set(2020, 6, 1) },
                Calendar.getInstance().apply { set(2023, 6, 1) })
        ),
        Coach(
            15,
            "Jurgen",
            "Klopp",
            "J. Klopp",
            Calendar.getInstance().apply { set(1967, 6, 16) },
            "Germany",
            Contract(
                Calendar.getInstance().apply { set(2020, 7, 1) },
                Calendar.getInstance().apply { set(2024, 7, 1) })
        ),
        Staff(
            16,
            "Jorge",
            "Desio",
            "J. Desio",
            Calendar.getInstance().apply { set(1966, 1, 1) },
            "Argentina",
            Contract(
                Calendar.getInstance().apply { set(2020, 6, 1) },
                Calendar.getInstance().apply { set(2023, 6, 1) })
        ),
        Staff(
            17,
            "Craig",
            "Mawson",
            "C. Mawson",
            Calendar.getInstance().apply { set(1973, 8, 22) },
            "England",
            Contract(
                Calendar.getInstance().apply { set(2020, 7, 1) },
                Calendar.getInstance().apply { set(2024, 7, 1) })
        )
    )

    private val random = java.util.Random()
    val matchList: MutableList<Match> = mutableListOf()

    fun initMatches() {
        matchList.add(
            Match(
                1,
                teamList[0],
                teamList[1],
                Calendar.getInstance()
                    .apply { set(2022, random.nextInt(12), random.nextInt(28) + 1) },
                "FINISHED",
                Score(1, 1, "DRAW")
            )
        )
        matchList.add(
            Match(
                2,
                teamList[2],
                teamList[0],
                Calendar.getInstance()
                    .apply { set(2022, random.nextInt(12), random.nextInt(28) + 1) },
                "FINISHED",
                Score(2, 0, "HOME_TEAM")
            )
        )
        matchList.add(
            Match(
                3,
                teamList[1],
                teamList[2],
                Calendar.getInstance()
                    .apply { set(2022, random.nextInt(12), random.nextInt(28) + 1) },
                "FINISHED",
                Score(0, 4, "AWAY_TEAM")
            )
        )
        matchList.add(
            Match(
                4,
                teamList[0],
                teamList[2],
                Calendar.getInstance()
                    .apply { set(2023, random.nextInt(12), random.nextInt(28) + 1) },
                "FINISHED",
                Score(0, 1, "AWAY_TEAM")
            )
        )
        matchList.add(
            Match(
                5,
                teamList[1],
                teamList[0],
                Calendar.getInstance()
                    .apply { set(2023, random.nextInt(12), random.nextInt(28) + 1) },
                "FINISHED",
                Score(0, 0, "DRAW")
            )
        )
        matchList.add(
            Match(
                6,
                teamList[2],
                teamList[1],
                Calendar.getInstance()
                    .apply { set(2023, random.nextInt(12), random.nextInt(28) + 1) },
                "FINISHED",
                Score(2, 0, "HOME_TEAM")
            )
        )
    }

    val teamList: MutableList<Team> = mutableListOf()

    fun initTeams() {
        teamList.add(
            Team(
                1,
                "Paris Saint-Germain FC",
                "PSG",
                "https://www.psg.fr/img/DefaultOpenGraphImage.jpg?20230329",
                "24 Rue du Commandant Guilbaud, 75016 Paris, France",
                "https://www.psg.fr/",
                "1970",
                "Navy / Red",
                areaList[0],
                "Parc des Princes",
                peopleList[13] as Coach,
                listOf(peopleList[15] as Staff),
                listOf(peopleList[0] as Player, peopleList[3] as Player, peopleList[11] as Player)
            )
        )
        teamList.add(
            Team(
                2,
                "FC Barcelona",
                "BAR",
                "https://upload.wikimedia.org/wikipedia/fr/thumb/a/a1/Logo_FC_Barcelona.svg/1200px-Logo_FC_Barcelona.svg.png",
                "Carrer d'Aristides Maillol, s/n, 08028 Barcelona, Spain",
                "https://www.fcbarcelona.com/",
                "1899",
                "Blue / Red",
                areaList[3],
                "Camp Nou",
                peopleList[14] as Coach,
                listOf(peopleList[16] as Staff),
                listOf(peopleList[2] as Player, peopleList[5] as Player, peopleList[9] as Player)
            )
        )
        teamList.add(
            Team(
                3,
                "Liverpool FC",
                "LIV",
                "https://upload.wikimedia.org/wikipedia/fr/thumb/5/54/Logo_FC_Liverpool.svg/1200px-Logo_FC_Liverpool.svg.png",
                "Anfield Road, Liverpool L4 0TH, United Kingdom",
                "https://www.liverpoolfc.com/",
                "1892",
                "Red",
                areaList[2],
                "Anfield",
                peopleList[14] as Coach,
                listOf(peopleList[15] as Staff),
                listOf(peopleList[7] as Player, peopleList[8] as Player, peopleList[10] as Player)
            )
        )
    }

    val competitionList: MutableList<Competition> = mutableListOf()

    fun initCompetitions() {
        competitionList.add(
            Competition(
                1,
                "Campeonato Brasileiro Série A",
                "BSA",
                "LEAGUE",
                "https://crests.football-data.org/764.svg",
                Season(
                    1557,
                    Calendar.getInstance().apply { set(2023, Calendar.MARCH, 15) },
                    Calendar.getInstance().apply { set(2022, Calendar.DECEMBER, 3) },
                    1,
                    null
                ),
                areaList[2],
            )
        )
        competitionList.add(
            Competition(
                2,
                "Championship",
                "ELC",
                "LEAGUE",
                "https://crests.football-data.org/PL.png",
                Season(
                    1557,
                    Calendar.getInstance().apply { set(2023, Calendar.MARCH, 15) },
                    Calendar.getInstance().apply { set(2022, Calendar.DECEMBER, 3) },
                    1,
                    null
                ),
                areaList[2],
            )
        )
    }


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

    class StubMatchesManager(private val parent: StubData) : MatchesManager {

        override fun getItems(): List<Match> = parent.matchList

        override fun getItemById(id: Int) = parent.matchList.find { it.id == id }

    }

    class StubCompetitionsManager(private val parent: StubData) : CompetitionsManager {
        override fun getItemsByName(substring: String) =
            parent.competitionList.filter { it.name.contains(substring, ignoreCase = true) }

        override fun getItems() = parent.competitionList

        override fun getItemById(id: Int) = parent.competitionList.find { it.id == id }

    }

    class StubTeamsManager(private val parent: StubData) : TeamsManager {
        override fun getItemsByName(substring: String) =
            parent.teamList.filter { it.name.contains(substring, ignoreCase = true) }

        override fun getItems() = parent.teamList

        override fun getItemById(id: Int) = parent.teamList.find { it.id == id }

    }
}