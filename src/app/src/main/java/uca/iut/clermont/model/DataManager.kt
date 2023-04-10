package uca.iut.clermont.model

abstract class DataManager {
    abstract val areaMgr: AreaManager
    abstract val peopleMgr: PeopleManager
    abstract val matchesMgr: MatchesManager
    abstract val competitionsMgr: CompetitionsManager
    abstract val teamsMgr: TeamsManager
}

interface AreaManager : GenericDataManager<Area> {
    suspend fun getItemsByName(substring: String): List<Area>
}

interface PeopleManager : GenericDataManager<Personne> {}

interface MatchesManager : GenericDataManager<Match> {
    suspend fun getNbItemsByCompetition(id: Int): Int

    suspend fun getItemsByCompetition(id: Int): List<Match>

}

interface CompetitionsManager : GenericDataManager<Competition> {
    suspend fun getItemsByName(substring: String): List<Competition>
}

interface TeamsManager : GenericDataManager<Team> {
    fun getItemsByName(substring: String): List<Team>

}