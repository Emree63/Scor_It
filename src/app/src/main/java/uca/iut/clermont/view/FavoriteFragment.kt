package uca.iut.clermont.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uca.iut.clermont.R
import uca.iut.clermont.model.Competition
import uca.iut.clermont.model.Match
import uca.iut.clermont.view.adapter.FavoritesAdapter
import uca.iut.clermont.view.adapter.MatchesAdapter

class FavoriteFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_favorite, container, false)

        val competitions = (activity as MainActivity).manager.competitionsMgr.getItems()
        var buttonHome = view.findViewById<ImageButton>(R.id.buttonHome)
        val buttonTextFavorite = view.findViewById<Button>(R.id.buttonTextHome)

        buttonHome.setOnClickListener {
            navigate()
        }

        buttonTextFavorite.setOnClickListener {
            navigate()
        }

        initRecyclerView(view, competitions)

        return view
    }

    fun navigate() {
        findNavController().navigate(R.id.homeFragment)
    }

    private fun initRecyclerView(view: View, favorites: List<Competition>) {
        val recyclerViewFavorites = view.findViewById<RecyclerView>(R.id.listFavorites)
        with(recyclerViewFavorites) {
            layoutManager = LinearLayoutManager(view.context)
            adapter = FavoritesAdapter(favorites.toList().toTypedArray())
        }
    }
}