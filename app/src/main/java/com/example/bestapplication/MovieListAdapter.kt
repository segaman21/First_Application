package com.example.bestapplication

import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class MovieListAdapter:RecyclerView.Adapter<MovieListViewHolder> (){
    val  moviesList =
            mutableListOf(
                    Movie(
                            "Avengers: End Game",
                            "Action, Adventure, Drama",
                            125,
                            4,
                            137,
                            13,
                            false,
                            R.drawable.mask_movie
                    ),
                    Movie(
                            "Tenet",
                            "Action, Sci-Fi, Thriller",
                            98,
                            4,
                            97,
                            16,
                            false,
                            R.drawable.ic_tenet_poster
                    ),
                    Movie(
                            "Black Widow",
                            "Action, Adventure, Sci-Fi",
                            38,
                            3,
                            102,
                            13,
                            false,
                            R.drawable.ic_widow_poster
                    ),
                    Movie(
                            "Wonder Woman 1984",
                            "Action, Adventure, Fantasy",
                            74,
                            1,
                            120,
                            13,
                            false,
                            R.drawable.ic_woman_poster
                    )
            )

    lateinit var callback: Callback
            override fun onCreateViewHolder (parent: ViewGroup, viewType: Int): MovieListViewHolder {
     val view = LayoutInflater.from(parent.context)
        .inflate(R.layout.fragment_movie,parent,false)
        return MovieListViewHolder(view)
    }
    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            callback.startMovieDetailsFragment()
        }
        val item = moviesList[position]
        holder.setRate(item.rate)
        holder.genere.text = item.genre
        holder.title.text = item.title
        holder.reviews.text = "${item.reviews} reviews"
        holder.time.text = "${item.duration} min"
        holder.tv_age.text = "+${item.ageRate}"
        holder.isliked.setOnClickListener {
            if (!item.isLiked) {
                holder.isliked.setImageDrawable(
                        ContextCompat.getDrawable(
                                holder.itemView.context,
                                R.drawable.ic_liked
                        )
                )
                item.isLiked = true
            } else {
                holder.isliked.setImageDrawable(
                        ContextCompat.getDrawable(
                                holder.itemView.context,
                                R.drawable.like
                        )
                )
                item.isLiked = false
            }
        }
        holder.poster.setImageDrawable(
                ContextCompat.getDrawable(
                        holder.itemView.context,
                        item.posterImage
                )
        )
    }
    fun initCallback(callback: FragmentMoviesList) {
        this.callback = callback
    }
    interface Callback {
        fun startMovieDetailsFragment()
    }
    override fun getItemCount(): Int {
        return moviesList.size
    }
}
