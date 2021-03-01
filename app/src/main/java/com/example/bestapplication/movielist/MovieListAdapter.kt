package com.example.bestapplication.movielist

import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import com.example.bestapplication.R
import com.example.bestapplication.data.model.Genre
import com.example.bestapplication.data.model.MoviePreview

class MovieListAdapter(val moviesList: List<MoviePreview>, val genres: List<Genre>) :
    RecyclerView.Adapter<MovieListViewHolder>() {
    lateinit var callback: Callback

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_movie, parent, false)
        return MovieListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        holder.onBind(moviesList[position], genres, this.callback)
    }

    fun initCallback(callback: FragmentMoviesList) {
        this.callback = callback
    }

    interface Callback {
        fun startMovieDetailsFragment(item: MoviePreview)
    }

}
