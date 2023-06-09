package uca.iut.clermont.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uca.iut.clermont.R
import uca.iut.clermont.application.ScorItApplication
import uca.iut.clermont.model.Competition
import uca.iut.clermont.view.adapter.CompetitionsAdapter
import uca.iut.clermont.view.viewModel.FavoriteViewModel
import uca.iut.clermont.view.viewModel.ViewModelFactory

class FavoriteFragment : Fragment(), CompetitionsAdapter.OnItemClickListener {

    private var favorites: List<Competition> = mutableListOf()

    private val viewModel: FavoriteViewModel by viewModels {
        ViewModelFactory((requireActivity().application as ScorItApplication).db.competitionDao())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_favorite, container, false)

        viewModel.getAllCompetitions().observe(viewLifecycleOwner, Observer { competitions ->
            competitions?.let {
                favorites = competitions
                initRecyclerView(view, competitions, this)
            }
        })

        initializeView(view)

        return view
    }

    private fun navigate() {
        findNavController().navigate(R.id.homeFragment)
    }

    private fun initializeView(view: View) {
        val buttonHome = view.findViewById<ImageButton>(R.id.buttonHome)
        val buttonTextFavorite = view.findViewById<Button>(R.id.buttonTextHome)

        buttonHome.setOnClickListener {
            navigate()
        }
        buttonTextFavorite.setOnClickListener {
            navigate()
        }

    }

    private fun initRecyclerView(
        view: View,
        favorites: List<Competition>,
        listener: CompetitionsAdapter.OnItemClickListener
    ) {
        val recyclerViewFavorites = view.findViewById<RecyclerView>(R.id.listFavorites)
        with(recyclerViewFavorites) {
            layoutManager = LinearLayoutManager(view.context)
            adapter = CompetitionsAdapter(favorites.toList().toTypedArray(), listener)
        }
    }

    override fun onItemClick(position: Int) {
        val bundle = bundleOf(
            "idItem" to favorites[position].id,
            "fragmentId" to R.id.favoriteFragment
        )
        findNavController().navigate(R.id.action_favoriteFragment_to_detailFragment, bundle)
    }

}