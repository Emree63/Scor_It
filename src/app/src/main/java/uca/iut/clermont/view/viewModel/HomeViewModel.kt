package uca.iut.clermont.view.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import uca.iut.clermont.api.ApiManager
import uca.iut.clermont.model.Match
import java.util.*

class HomeViewModel : ViewModel() {

    val manager = ApiManager()
    val matches = MutableLiveData<List<Match>?>()

    fun loadMatches() = viewModelScope.launch {
        val matchResults = manager.matchesMgr.getItems()
        matches.value = matchResults.filter { it.status != "TIMED" }
            .apply { forEach { it.date.add(Calendar.HOUR_OF_DAY, 2) } }
            .sortedBy { it.competition.name }
            .sortedByDescending { it.date }
    }

}