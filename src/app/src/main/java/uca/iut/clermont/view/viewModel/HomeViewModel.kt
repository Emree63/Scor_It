package uca.iut.clermont.view.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import uca.iut.clermont.api.ApiManager
import uca.iut.clermont.model.Match

class HomeViewModel : ViewModel() {

    val manager = ApiManager()
    val matches = MutableLiveData<List<Match>?>()

    fun loadMatches() = viewModelScope.launch {
        val matchResult = manager.matchesMgr.getItems()
        matches.value = matchResult.filter { it.status == "FINISHED" }
    }

}