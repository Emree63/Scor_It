package uca.iut.clermont.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uca.iut.clermont.R
import uca.iut.clermont.model.Match
import uca.iut.clermont.view.adapter.MatchesAdapter

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val matches = (activity as MainActivity).manager.matchesMgr.getItems()

        initRecyclerView(view, matches)
        return view
    }

    private fun initRecyclerView(view: View, matches: List<Match>) {
        val recyclerViewMatches = view.findViewById<RecyclerView>(R.id.ListRecentsMatches)
        with(recyclerViewMatches) {
            layoutManager = LinearLayoutManager(view.context)
            adapter = MatchesAdapter(matches.toList().toTypedArray())

        }

    }



}