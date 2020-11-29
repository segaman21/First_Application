package com.example.bestapplication

import android.os.Bundle
import android.text.TextUtils.replace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FragmentMoviesList : Fragment () {
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_movies_list, container,false)
        return view
         }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val movieItem = view.findViewById<View>(R.id.movies_detals)
        movieItem.setOnClickListener{
            fragmentManager?.beginTransaction()
            ?.replace(R.id.fragment_container, FragmentMoviesDetails())
            ?.addToBackStack(null)
            ?.commit()
        }
    }
}
