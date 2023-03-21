package uca.iut.clermont.view

import android.app.Activity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uca.iut.clermont.R
import uca.iut.clermont.data.StubData
import uca.iut.clermont.view.adapter.MatchesAdapter
import java.util.*

class HomeActivity : Activity() {

    private var manager = StubData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val imageFirstTeam = findViewById<ImageView>(R.id.ImageFirstTeam)

        /*val adapterMatches = findViewById<RecyclerView>(R.id.ListRecentsMatches)

        with(adapterMatches) {
            adapter = MatchesAdapter(manager.matchesMgr.getItems())
        }*/

        Glide.with(this)
            .load("https://crests.football-data.org/1765.svg")
            .error(R.drawable.imagenotfound)
            .into(imageFirstTeam)

    }
}