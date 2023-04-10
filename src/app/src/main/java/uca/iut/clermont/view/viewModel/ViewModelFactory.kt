package uca.iut.clermont.view.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import uca.iut.clermont.data.dao.CompetitionDao

class ViewModelFactory(private val dao: CompetitionDao): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavoriteViewModel::class.java)){
            return FavoriteViewModel(dao) as T
        }
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)){
            return DetailViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown viewModel class")
    }

}