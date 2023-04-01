package uca.iut.clermont.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uca.iut.clermont.R


class StartFragment : Fragment() {

    private lateinit var ball: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_start, container, false)

        ball = view.findViewById(R.id.ball)

        val buttonFavorite = view.findViewById<ImageButton>(R.id.nextButton)

        buttonFavorite.setOnClickListener {
            findNavController().navigate(R.id.homeFragment)
        }

        return view
    }


}