package uca.iut.clermont.view.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import uca.iut.clermont.api.ApiManager
import uca.iut.clermont.data.dao.CompetitionDao
import uca.iut.clermont.model.Competition
import uca.iut.clermont.model.Match
import java.util.*

class DetailViewModel(
    val dao: CompetitionDao
) : ViewModel() {

    val ERROR = "too many requests"
    val manager = ApiManager()
    val competition = MutableLiveData<Competition?>()
    val competitionMatches = MutableLiveData<List<Match>>()
    val nbCompetitionMatches = MutableLiveData<Int>()
    val isFavorite = MutableLiveData<Boolean>()

    fun insertCompetition(competition: Competition) =
        viewModelScope.launch(Dispatchers.IO) {
            dao.insertCompetition(competition)
        }

    fun deleteCompetition(competition: Competition) =
        viewModelScope.launch(Dispatchers.IO) {
            dao.deleteCompetition(competition)
        }

    fun check(id: Int) = dao.getCompetitionById(id).asLiveData()

    fun loadCurrentCompetition(id: Int) = viewModelScope.launch {
        try {
            val result = manager.competitionsMgr.getItemById(id)
            competition.value = result
        } catch (e: HttpException) {
            Log.d(e.toString(), ERROR)
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
            Log.d(e.toString(), ERROR)
        }
    }

    fun loadNumberMatches() = viewModelScope.launch {
        try {
            nbCompetitionMatches.value = competitionMatches.value?.size
        } catch (e: HttpException) {
            Log.d(e.toString(), ERROR)
        }
    }
}