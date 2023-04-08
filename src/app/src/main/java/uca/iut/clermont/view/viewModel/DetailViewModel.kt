package uca.iut.clermont.view.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import uca.iut.clermont.api.ApiManager
import uca.iut.clermont.model.Competition
import uca.iut.clermont.model.Match
import java.util.*

class DetailViewModel : ViewModel() {

    val manager = ApiManager()
    val competition = MutableLiveData<Competition?>()
    val competitionMatches = MutableLiveData<List<Match>>()
    val nbCompetitionMatches = MutableLiveData<Int>()

    fun loadCurrentCompetition(id: Int) = viewModelScope.launch {
        val result = manager.competitionsMgr.getItemById(id)
        competition.value = result
    }

    fun loadMatches(id: Int) = viewModelScope.launch {

        val matchResults = manager.matchesMgr.getItemsByCompetition(id)
        competitionMatches.value = matchResults.filter { it.status != "TIMED" && it.status != "SCHEDULED" }
            .apply { forEach { it.date.add(Calendar.HOUR_OF_DAY, 2) } }
            .sortedBy { it.competition.name }
            .sortedByDescending { it.date }
    }

    fun loadNumberMatches(id: Int) = viewModelScope.launch {
        val nb = manager.matchesMgr.getNbItemsByCompetition(id)
        nbCompetitionMatches.value = nb
    }
}