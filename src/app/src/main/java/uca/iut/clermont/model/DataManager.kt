import uca.iut.clermont.model.*

abstract class DataManager {
    abstract val areaMgr: AreaManager
    abstract val peopleMgr: PeopleManager
    abstract val matchesMgr: MatchesManager
    abstract val competitionsMgr: CompetitionsManager
    abstract val teamsMgr: TeamsManager
}

interface AreaManager : GenericDataManager<Area>

interface PeopleManager : GenericDataManager<Personne>

interface MatchesManager : GenericDataManager<Match>

interface CompetitionsManager : GenericDataManager<Competition>

interface TeamsManager : GenericDataManager<Team>