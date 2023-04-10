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

class HomeViewModel : ViewModel() {

    val ERROR = "too many requests"
    val manager = ApiManager()
    val matches = MutableLiveData<List<Match>?>()
    val competitions = MutableLiveData<List<Competition>>()

    fun loadMatches() = viewModelScope.launch {
        try {
            val matchResults = manager.matchesMgr.getItems()
            matches.value = matchResults.filter { it.status != "TIMED" }
                .apply { forEach { it.date.add(Calendar.HOUR_OF_DAY, 2) } }
                .sortedBy { it.competition.name }
                .sortedByDescending { it.date }
        } catch (e: HttpException) {
            Log.d(e.toString(),ERROR)
        }
    }

    fun loadCompetitions() = viewModelScope.launch {
        try {
            val result = manager.competitionsMgr.getItems()
            competitions.value = result
        } catch (e: HttpException) {
            Log.d(e.toString(),ERROR)
        }
    }

}