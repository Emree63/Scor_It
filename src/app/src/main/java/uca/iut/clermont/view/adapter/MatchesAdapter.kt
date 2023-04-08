package uca.iut.clermont.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uca.iut.clermont.R
import uca.iut.clermont.model.Match
import uca.iut.clermont.view.viewHolder.MatchHolder
import java.text.SimpleDateFormat
import java.util.*

class MatchesAdapter(private val recentMatches: Array<Match>) :
    RecyclerView.Adapter<MatchHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MatchHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.cellule_match, parent, false)
    )


    override fun onBindViewHolder(holder: MatchHolder, position: Int) {
        holder.titleFirstTeam.text = recentMatches[position].homeTeam.name
        holder.titleSecondTeam.text = recentMatches[position].awayTeam.name
        if (recentMatches[position].score.home != null) {
            holder.scoreHomeTeam.text = recentMatches[position].score.home.toString()
        } else {
            holder.scoreHomeTeam.text = "0"
        }

        if (recentMatches[position].score.away != null) {
            holder.scoreAwayTeam.text = recentMatches[position].score.away.toString()
        } else {
            holder.scoreAwayTeam.text = "0"
        }

        val date = recentMatches[position].date
        val formatter = SimpleDateFormat("dd/MM/yyyy' 'HH:mm", Locale.US)
        val formattedDate = formatter.format(date.time)

        with(holder.iconStatus) {
            setImageResource(R.drawable.mi_temp)
            layoutParams.width = 0
            layoutParams.height = 0
            (layoutParams as ViewGroup.MarginLayoutParams).apply {
                topMargin = 8
                bottomMargin = 7
            }
        }

        if (recentMatches[position].status == "IN_PLAY") {
            with(holder.iconStatus) {
                setImageResource(R.drawable.live)
                layoutParams.width = 130
                layoutParams.height = 130
                (layoutParams as ViewGroup.MarginLayoutParams).apply {
                    topMargin = 0
                    bottomMargin = 0
                }
            }
        }

        if (recentMatches[position].status == "PAUSED") {
            with(holder.iconStatus) {
                setImageResource(R.drawable.mi_temp)
                layoutParams.width = 100
                layoutParams.height = 100
            }
        }

        holder.dateCompetition.text =
            recentMatches[position].competition.name.plus(" : ").plus(formattedDate)

        Glide.with(holder.itemView.context)
            .load(recentMatches[position].homeTeam.crest)
            .error(R.drawable.imagenotfound)
            .into(holder.imageHomeTeam)

        Glide.with(holder.itemView.context)
            .load(recentMatches[position].awayTeam.crest)
            .error(R.drawable.imagenotfound)
            .into(holder.imageAwayTeam)
    }

    override fun getItemCount() = recentMatches.size

}