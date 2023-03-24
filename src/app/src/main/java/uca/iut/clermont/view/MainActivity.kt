package uca.iut.clermont.view

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import uca.iut.clermont.R
import uca.iut.clermont.data.StubData


class MainActivity : AppCompatActivity() {

    var manager = StubData()

    private lateinit var navController: NavController


    @RequiresApi(Build.VERSION_CODES.R)
    private fun hideSystemUI() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(
            window,
            window.decorView.findViewById(android.R.id.content)
        ).let { controller ->
            controller.hide(WindowInsetsCompat.Type.systemBars())
            controller.systemBarsBehavior =
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }

    }


    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideSystemUI()
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        manager.initTeams()
        manager.initMatches()

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment

        val navController = navHostFragment.navController

        //val imageFirstTeam = findViewById<ImageView>(R.id.ImageFirstTeam)
        /*Glide.with(this)
            .load("https://crests.football-data.org/1765.svg")
            .error(R.drawable.imagenotfound)
            .into(imageFirstTeam)*/

    }


}