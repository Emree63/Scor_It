package uca.iut.clermont.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import uca.iut.clermont.R

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        /*val adapterMatches = findViewById<RecyclerView>(R.id.ListRecentsMatches)

        with(adapterMatches) {
            adapter = MatchesAdapter(manager.matchesMgr.getItems().toList().toTypedArray())
        }

        adapterMatches.layoutManager = LinearLayoutManager(this)*/

        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}