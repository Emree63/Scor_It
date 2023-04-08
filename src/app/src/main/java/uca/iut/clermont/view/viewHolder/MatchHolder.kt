package uca.iut.clermont.view.viewHolder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uca.iut.clermont.R

class MatchHolder(view: View) : RecyclerView.ViewHolder(view) {
    val titleFirstTeam: TextView
    val titleSecondTeam: TextView
    val scoreHomeTeam: TextView
    val scoreAwayTeam: TextView
    val imageHomeTeam: ImageView
    val imageAwayTeam: ImageView
    val iconStatus: ImageView
    val dateCompetition: TextView

    init {
        titleFirstTeam = view.findViewById(R.id.TitleFirstTeam)
        titleSecondTeam = view.findViewById(R.id.TitleSecondTeam)
        scoreHomeTeam = view.findViewById(R.id.ScoreHomeTeam)
        scoreAwayTeam = view.findViewById(R.id.ScoreAwayTeam)
        imageHomeTeam = view.findViewById(R.id.ImageFirstTeam)
        imageAwayTeam = view.findViewById(R.id.ImageSecondTeam)
        dateCompetition = view.findViewById(R.id.DateCompetition)
        iconStatus = view.findViewById(R.id.iconStatus)

    }


}