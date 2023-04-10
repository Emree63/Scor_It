package uca.iut.clermont.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uca.iut.clermont.R
import uca.iut.clermont.model.Competition
import uca.iut.clermont.model.Match
import uca.iut.clermont.view.adapter.CompetitionsAdapter
import uca.iut.clermont.view.adapter.MatchesAdapter
import uca.iut.clermont.view.viewModel.HomeViewModel

class HomeFragment : Fragment(), CompetitionsAdapter.OnItemClickListener {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var searchBar: EditText
    private lateinit var searchAdapter: RecyclerView
    private var searchList: MutableList<Competition> = mutableListOf()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val buttonFavorite = view.findViewById<ImageButton>(R.id.buttonFavorite)
        val restartMatches = view.findViewById<ImageButton>(R.id.restartMatches)
        searchAdapter = view.findViewById(R.id.listSearch)

        searchBar = view.findViewById(R.id.searchBar);
        searchBar.addTextChangedListener(textWatcher);
        val text = view.findViewById<TextView>(R.id.textEmpty)
        viewModel.matches.observe(viewLifecycleOwner, Observer { matches ->
            matches?.let {
                if (it.isNotEmpty()) {
                    initRecyclerView(view, it, this)
                } else {
                    text.setText(R.string.noMatches)
                }
            }
        })

        searchAdapter.layoutManager = LinearLayoutManager(view.context)


        displayMatches()
        viewModel.loadCompetitions()

        buttonFavorite.setOnClickListener {
            findNavController().navigate(R.id.favoriteFragment)
        }

        restartMatches.setOnClickListener {
            displayMatches()
        }

        return view
    }

    private val textWatcher = object : TextWatcher {

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            searchNames(s.toString())
        }

        override fun afterTextChanged(s: Editable?) {
        }
    }

    private fun searchNames(query: String) {
        val filteredCompetition = viewModel.competitions.value.orEmpty()
            .asSequence()
            .filter { it.name.lowercase().contains(query.lowercase()) }
            .take(3)
            .toMutableList()
        searchList = filteredCompetition
        searchList(filteredCompetition, this)
    }

    private fun initRecyclerView(
        view: View,
        matches: List<Match>,
        listener: CompetitionsAdapter.OnItemClickListener
    ) {
        val recyclerViewMatches = view.findViewById<RecyclerView>(R.id.listRecentsMatches)
        with(recyclerViewMatches) {
            layoutManager = LinearLayoutManager(view.context)
            adapter = MatchesAdapter(matches.toList().toTypedArray())
        }

    }

    private fun searchList(
        competitons: List<Competition>,
        listener: CompetitionsAdapter.OnItemClickListener
    ) {
        searchAdapter.adapter = CompetitionsAdapter(competitons.toTypedArray(), listener)

    }

    private fun displayMatches() {
        viewModel.loadMatches()
    }

    override fun onPause() {
        super.onPause()
        searchBar.removeTextChangedListener(textWatcher)
    }

    override fun onItemClick(position: Int) {
        val bundle = bundleOf(
            "idItem" to searchList[position].id,
            "fragmentId" to R.id.homeFragment
        )
        findNavController().navigate(R.id.action_homeFragment_to_detailFragment, bundle)
    }

}