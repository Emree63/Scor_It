package uca.iut.clermont.view.viewHolder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uca.iut.clermont.R

class FavoriteHolder(view: View) : RecyclerView.ViewHolder(view)  {
    val imageFavorites: ImageView
    val textFavorites: TextView

    init {
        imageFavorites = view.findViewById(R.id.imageFavorites)
        textFavorites = view.findViewById(R.id.textFavorites)
    }
}