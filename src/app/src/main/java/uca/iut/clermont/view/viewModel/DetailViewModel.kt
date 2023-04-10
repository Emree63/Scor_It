package uca.iut.clermont.view.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.HttpException
import uca.iut.clermont.api.ApiManager
import uca.iut.clermont.model.Competition
import uca.iut.clermont.model.Match
import java.util.*

class DetailViewModel(
    //val dao: CompetitionDao
) : ViewModel() {

    val manager = ApiManager()
    val competition = MutableLiveData<Competition?>()
    val competitionMatches = MutableLiveData<List<Match>>()
    val nbCompetitionMatches = MutableLiveData<Int>()

    /*fun insertCompetition(competition: Competition) =
        viewModelScope.launch {
            dao.insertCompetition(competition)
        }
    */

    fun loadCurrentCompetition(id: Int) = viewModelScope.launch {
        try {
            val result = manager.competitionsMgr.getItemById(id)
            competition.value = result
        } catch (e: HttpException) {
            Log.d(e.toString(), ": too many requests")
        }
    }

    fun loadMatches(id: Int) = viewModelScope.launch {
        try {
            val matchResults = manager.matchesMgr.getItemsByCompetition(id)
            competitionMatches.value =
                matchResults.filter { it.status != "TIMED" && it.status != "SCHEDULED" && it.status != "POSTPONED" }
                    .apply { forEach { it.date.add(Calendar.HOUR_OF_DAY, 2) } }
                    .sortedBy { it.competition.name }
                    .sortedByDescending { it.date }
        } catch (e: HttpException) {
            Log.d(e.toString(), ": too many requests")
        }
    }

    fun loadNumberMatches() = viewModelScope.launch {
        try {
            nbCompetitionMatches.value = competitionMatches.value?.size
        } catch (e: HttpException) {
            Log.d(e.toString(), ": too many requests")
        }
    }
}