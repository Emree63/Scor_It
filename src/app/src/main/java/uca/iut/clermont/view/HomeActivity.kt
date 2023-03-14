package uca.iut.clermont.view

import android.app.Activity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import uca.iut.clermont.R

class HomeActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val imageFirstTeam = findViewById<ImageView>(R.id.ImageFirstTeam)

        Glide.with(this)
            .load("https://crests.football-data.org/1765.svg")
            .error(R.drawable.imagenotfound)
            .into(imageFirstTeam)

    }
}