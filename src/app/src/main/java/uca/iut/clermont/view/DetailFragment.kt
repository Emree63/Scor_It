package uca.iut.clermont.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import uca.iut.clermont.R
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uca.iut.clermont.application.ScorItApplication
import uca.iut.clermont.model.Competition
import uca.iut.clermont.view.adapter.MatchesAdapter
import uca.iut.clermont.view.viewModel.DetailViewModel
import uca.iut.clermont.view.viewModel.ViewModelFactory
import java.text.SimpleDateFormat
import java.util.*

class DetailFragment : Fragment() {

    private var isLiked = false
    private lateinit var competition: Competition
    private val viewModel: DetailViewModel by viewModels {
        ViewModelFactory((requireActivity().application as ScorItApplication).db.competitionDao())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        val likeButton = view.findViewById<ImageButton>(R.id.buttonLike)
        val id = arguments?.getInt("idItem")!!

        viewModel.competition.observe(viewLifecycleOwner, Observer { comp ->
            comp?.let {
                competition = comp
                initializeView(view)
                initRecyclerView(view)
            }
        })

        viewModel.loadCurrentCompetition(id)

        viewModel.nbCompetitionMatches.observe(viewLifecycleOwner, Observer { comp ->
            comp?.let {
                initNumberMatches(view)
            }
        })

        viewModel.check(id).observe(viewLifecycleOwner, Observer { competition ->
            competition?.let {
                isLiked = true
                likeButton.setImageResource(R.drawable.full_like)
            }
        })

        likeButton.setOnClickListener {
            if (isLiked) {
                viewModel.deleteCompetition(competition)
                likeButton.setImageResource(R.drawable.empty_like)
            } else {
                viewModel.insertCompetition(competition)
                likeButton.setImageResource(R.drawable.full_like)
            }
            isLiked = !isLiked
        }

        viewModel.competitionMatches.observe(viewLifecycleOwner, Observer { competitions ->
            competitions?.let {
                initRecyclerView(view)
                viewModel.loadNumberMatches()
            }
        })

        viewModel.loadMatches(id)

        return view;
    }

    private fun initializeView(view: View) {
        val buttonExit = view.findViewById<ImageButton>(R.id.buttonExit)
        val imageHeader = view.findViewById<ImageView>(R.id.imageDetail)
        val titleHeader = view.findViewById<TextView>(R.id.title)
        val dateEnd = view.findViewById<TextView>(R.id.dateEnd)
        val dateStart = view.findViewById<TextView>(R.id.dateStart)

        val fragmentId = arguments?.getInt("fragmentId")

        buttonExit.setOnClickListener {
            fragmentId?.let {
                findNavController().navigate(fragmentId)
            }
        }

        Glide.with(view.context)
            .load(competition.emblem)
            .error(R.drawable.imagenotfound)
            .into(imageHeader)

        titleHeader.text = competition.name
        var date = competition.currentSeason.endDate

        var formatter = SimpleDateFormat("dd-MM-yyyy", Locale.US)
        var formattedDate = formatter.format(date.time)

        dateEnd.text = formattedDate

        date = competition.currentSeason.startDate

        formatter = SimpleDateFormat("dd-MM-yyyy", Locale.US)
        formattedDate = formatter.format(date.time)

        dateStart.text = formattedDate

    }

    private fun initNumberMatches(view: View) {
        val nbMatches = view.findViewById<TextView>(R.id.nbMatches)

        nbMatches.text = viewModel.nbCompetitionMatches.value.toString()
    }

    private fun initRecyclerView(view: View) {
        val recyclerViewMatches = view.findViewById<RecyclerView>(R.id.listRecentsMatches)
        with(recyclerViewMatches) {
            layoutManager = LinearLayoutManager(view.context)
            adapter = viewModel.competitionMatches.value?.toList()?.let {
                MatchesAdapter(
                    it.toTypedArray()
                )
            }
        }
    }
}