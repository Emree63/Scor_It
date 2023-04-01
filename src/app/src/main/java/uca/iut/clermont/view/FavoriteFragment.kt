package uca.iut.clermont.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uca.iut.clermont.R
import uca.iut.clermont.model.Competition
import uca.iut.clermont.view.adapter.FavoritesAdapter

class FavoriteFragment : Fragment(), FavoritesAdapter.OnItemClickListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_favorite, container, false)
        var competitions = (activity as MainActivity).manager.competitionsMgr.getItems()

        initRecyclerView(view, competitions, this)
        initializeView(view)

        return view
    }

    private fun navigate() {
        findNavController().navigate(R.id.homeFragment)
    }

    private fun initializeView(view: View) {
        var buttonHome = view.findViewById<ImageButton>(R.id.buttonHome)
        var buttonTextFavorite = view.findViewById<Button>(R.id.buttonTextHome)

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
        listener: FavoritesAdapter.OnItemClickListener
    ) {
        val recyclerViewFavorites = view.findViewById<RecyclerView>(R.id.listFavorites)
        with(recyclerViewFavorites) {
            layoutManager = LinearLayoutManager(view.context)
            adapter = FavoritesAdapter(favorites.toList().toTypedArray(), listener)
        }
    }

    override fun onItemClick(position: Int) {
        var competitions = (activity as MainActivity).manager.competitionsMgr.getItems()
        val bundle = bundleOf("idItem" to competitions[position].id)
        findNavController().navigate(R.id.action_favoriteFragment_to_detailFragment, bundle)
    }
}