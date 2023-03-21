package uca.iut.clermont.view.viewHolder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uca.iut.clermont.R

class MatchHolder(view: View) : RecyclerView.ViewHolder(view) {
    val textView: TextView

    init {
        // Define click listener for the ViewHolder's View
        textView = view.findViewById(R.id.TitleFirstTeam)
    }


}