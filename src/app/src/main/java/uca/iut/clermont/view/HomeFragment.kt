package uca.iut.clermont.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uca.iut.clermont.R
import uca.iut.clermont.model.Match
import uca.iut.clermont.view.adapter.MatchesAdapter
import uca.iut.clermont.view.viewModel.HomeViewModel

class HomeFragment : Fragment() {

    val viewModel: HomeViewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val buttonFavorite = view.findViewById<ImageButton>(R.id.buttonFavorite)
        val restartMatches = view.findViewById<ImageButton>(R.id.restartMatches)

        val text = view.findViewById<TextView>(R.id.textEmpty)
        viewModel.matches.observe(viewLifecycleOwner, Observer { matches ->
            matches?.let {
                if (it.isNotEmpty()) {
                    initRecyclerView(view, it)
                } else {
                    text.setText("No games started yet!")
                }
            }
        })

        displayMatches(view)

        buttonFavorite.setOnClickListener {
            findNavController().navigate(R.id.favoriteFragment)
        }

        restartMatches.setOnClickListener {
            displayMatches(view)
        }

        return view
    }

    private fun initRecyclerView(view: View, matches: List<Match>) {
        val recyclerViewMatches = view.findViewById<RecyclerView>(R.id.listRecentsMatches)
        with(recyclerViewMatches) {
            layoutManager = LinearLayoutManager(view.context)
            adapter = MatchesAdapter(matches.toList().toTypedArray())

        }

    }

    private fun displayMatches(view: View) {
        viewModel.loadMatches()
    }


}