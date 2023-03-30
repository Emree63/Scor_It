package uca.iut.clermont.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import uca.iut.clermont.R

class DetailFragment : Fragment() {

    private var isLiked = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        val button = view.findViewById<ImageButton>(R.id.buttonLike)

        button.setOnClickListener {
            isLiked = !isLiked

            button.setImageResource(if (isLiked) R.drawable.full_like else R.drawable.empty_like)
        }

        return view;
    }

}