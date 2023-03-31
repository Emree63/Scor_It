package uca.iut.clermont.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uca.iut.clermont.R
import uca.iut.clermont.model.Competition

class FavoritesAdapter(
    private val favoriteCompetition: Array<Competition>,
    private val listener: OnItemClickListener,
) :
    RecyclerView.Adapter<FavoritesAdapter.FavoriteHolder>() {

    inner class FavoriteHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        val imageFavorites: ImageView
        val textFavorites: TextView

        init {
            itemView.setOnClickListener(this)
            imageFavorites = view.findViewById(R.id.imageFavorites)
            textFavorites = view.findViewById(R.id.textFavorites)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            listener.onItemClick(position)
        }

    }

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

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }


    override fun getItemCount() = favoriteCompetition.size

}