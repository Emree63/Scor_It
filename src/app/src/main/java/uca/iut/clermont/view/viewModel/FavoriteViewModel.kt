package uca.iut.clermont.view.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import uca.iut.clermont.api.ApiManager
import uca.iut.clermont.model.Competition

class FavoriteViewModel(
    //val dao: CompetitionDao
) : ViewModel() {

    val manager = ApiManager()
    val competitions = MutableLiveData<List<Competition>>()

    //fun getAllCompetitions() = dao.getAllCompetitions()
    //.isLiveDate()

    fun loadCompetitions() = viewModelScope.launch {
        val result = manager.competitionsMgr.getItems()
        competitions.value = result
    }

}