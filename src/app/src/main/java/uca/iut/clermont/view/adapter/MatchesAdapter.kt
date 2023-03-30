package uca.iut.clermont.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uca.iut.clermont.R
import uca.iut.clermont.model.Match
import uca.iut.clermont.view.viewHolder.MatchHolder

class MatchesAdapter(private val recentMatches: Array<Match>) :
    RecyclerView.Adapter<MatchHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchHolder {
        return MatchHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.cellule_match, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MatchHolder, position: Int) {
        holder.titleFirstTeam.text = recentMatches[position].homeTeam.name
        holder.titleSecondTeam.text = recentMatches[position].awayTeam.name
        holder.scoreHomeTeam.text = recentMatches[position].score.home.toString()
        holder.scoreAwayTeam.text = recentMatches[position].score.away.toString()

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