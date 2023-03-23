package uca.iut.clermont.view

import android.app.Activity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import uca.iut.clermont.R
import uca.iut.clermont.data.StubData

class MainActivity : Activity() {

    private var manager = StubData()

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = findNavController(R.id.fragment) as NavHostFragment

        navController = navHostFragment.navController

        //val imageFirstTeam = findViewById<ImageView>(R.id.ImageFirstTeam)
        /*Glide.with(this)
            .load("https://crests.football-data.org/1765.svg")
            .error(R.drawable.imagenotfound)
            .into(imageFirstTeam)*/

    }
}