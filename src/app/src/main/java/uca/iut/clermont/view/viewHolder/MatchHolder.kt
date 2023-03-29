package uca.iut.clermont.view.viewHolder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uca.iut.clermont.R

class MatchHolder(view: View) : RecyclerView.ViewHolder(view) {
    val titleFirstTeam: TextView
    val titleSecondTeam: TextView
    val scoreHomeTeam: TextView
    val scoreAwayTeam: TextView

    init {
        titleFirstTeam = view.findViewById(R.id.TitleFirstTeam)
        titleSecondTeam = view.findViewById(R.id.TitleSecondTeam)
        scoreHomeTeam = view.findViewById(R.id.ScoreHomeTeam)
        scoreAwayTeam = view.findViewById(R.id.ScoreAwayTeam)
    }


}