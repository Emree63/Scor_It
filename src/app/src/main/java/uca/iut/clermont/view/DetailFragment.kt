package uca.iut.clermont.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import uca.iut.clermont.R
import uca.iut.clermont.model.Competition
import java.text.SimpleDateFormat

class DetailFragment : Fragment() {

    private var isLiked = false
    private lateinit var competition: Competition

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        val id = arguments?.getInt("idItem")!!

        competition = (activity as MainActivity).manager.competitionsMgr.getItemById(id)!!

        initializeView(view)
        return view;
    }

    private fun initializeView(view: View) {
        val button = view.findViewById<ImageButton>(R.id.buttonLike)
        val buttonExit = view.findViewById<ImageButton>(R.id.buttonExit)
        val imageHeader = view.findViewById<ImageView>(R.id.imageDetail)
        val titleHeader = view.findViewById<TextView>(R.id.title)
        val dateEnd = view.findViewById<TextView>(R.id.dateEnd)
        val dateStart = view.findViewById<TextView>(R.id.dateStart)

        buttonExit.setOnClickListener {
            findNavController().navigate(R.id.favoriteFragment)
        }

        button.setOnClickListener {
            isLiked = !isLiked
            button.setImageResource(if (isLiked) R.drawable.full_like else R.drawable.empty_like)
        }

        Glide.with(view.context)
            .load(competition.emblem)
            .error(R.drawable.imagenotfound)
            .into(imageHeader)

        titleHeader.text = competition.name
        var date = competition.currentSeason.endDate

        var formatter = SimpleDateFormat("dd-MM-yyyy")
        var formattedDate = formatter.format(date.time)

        dateEnd.text = formattedDate

        date = competition.currentSeason.startDate

        formatter = SimpleDateFormat("dd-MM-yyyy")
        formattedDate = formatter.format(date.time)

        dateStart.text = formattedDate
    }

}