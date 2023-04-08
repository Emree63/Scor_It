import uca.iut.clermont.model.*

abstract class DataManager {
    abstract val areaMgr: AreaManager
    abstract val peopleMgr: PeopleManager
    abstract val matchesMgr: MatchesManager
    abstract val competitionsMgr: CompetitionsManager
    abstract val teamsMgr: TeamsManager
}

interface AreaManager : GenericDataManager<Area> {
    fun getItemsByName(substring: String): List<Area>
}

interface PeopleManager : GenericDataManager<Personne> {
    fun getItemsByName(substring: String): List<Personne>
}

interface MatchesManager : GenericDataManager<Match> {
    fun getNbItemsByCompetition(substring: String): Int

    fun getItemsByCompetition(substring: String): List<Match>

}

interface CompetitionsManager : GenericDataManager<Competition> {
    fun getItemsByName(substring: String): List<Competition>
}

interface TeamsManager : GenericDataManager<Team> {
    fun getItemsByName(substring: String): List<Team>

}