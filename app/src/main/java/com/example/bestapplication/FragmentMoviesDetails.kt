package com.example.bestapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentMoviesDetails : Fragment (){
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_movies_details, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_name)
        val actorAdapter = ActorAdapter()
        recyclerView.adapter = actorAdapter
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val backButton = view.findViewById<ImageView>(R.id.imageView_back)
        backButton.setOnClickListener {
            requireActivity().onBackPressed()
        }

    }

}