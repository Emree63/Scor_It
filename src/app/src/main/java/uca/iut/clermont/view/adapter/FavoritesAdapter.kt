package uca.iut.clermont.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uca.iut.clermont.R
import uca.iut.clermont.model.Competition
import uca.iut.clermont.view.viewHolder.FavoriteHolder

class FavoritesAdapter(private val favoriteCompetition: Array<Competition> ) : RecyclerView.Adapter<FavoriteHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteHolder {
        return FavoriteHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.cellule_favorite, parent, false)
        )
    }

    override fun onBindViewHolder(holder: FavoriteHolder, position: Int) {
        holder.textFavorites.text = favoriteCompetition[position].name

        Glide.with(holder.itemView.context)
            .load(favoriteCompetition[position].emblem)
            .error(R.drawable.imagenotfound)
            .into(holder.imageFavorites)
    }

    override fun getItemCount() = favoriteCompetition.size


}