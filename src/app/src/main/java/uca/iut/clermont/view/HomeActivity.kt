package uca.iut.clermont.view

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import uca.iut.clermont.R

class HomeActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        Glide.with(this)
            .load("https://crests.football-data.org/1765.svg")
            .into(findViewById(R.id.ImageFirstTeam))
    }
}