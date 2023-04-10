package uca.iut.clermont.view.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import uca.iut.clermont.data.dao.CompetitionDao

class FavoriteViewModel(
    val dao: CompetitionDao
) : ViewModel() {
    fun getAllCompetitions() = dao.getAllCompetitions().asLiveData()
}