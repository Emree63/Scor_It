package uca.iut.clermont.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uca.iut.clermont.R
import uca.iut.clermont.model.Match
import uca.iut.clermont.view.viewHolder.MatchHolder

class MatchesAdapter(val recentMatches: Array<Match>) : RecyclerView.Adapter<MatchHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchHolder {
        return MatchHolder(LayoutInflater.from(parent.context).inflate(R.layout.cellule_match, parent, false))
    }

    override fun onBindViewHolder(holder: MatchHolder, position: Int) {
        holder.textView.text = recentMatches[position].id.toString()
    }

    override fun getItemCount() = recentMatches.size

}