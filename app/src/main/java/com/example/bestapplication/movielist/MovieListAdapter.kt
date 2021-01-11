package com.example.bestapplication.movielist

import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bestapplication.R
import com.example.bestapplication.data.Genre
import com.example.bestapplication.data.Movie

class MovieListAdapter:RecyclerView.Adapter<MovieListViewHolder> (){
    val  adapterMoviesList = mutableListOf<Movie>()

    lateinit var callback: Callback
    override fun onCreateViewHolder (parent: ViewGroup, viewType: Int): MovieListViewHolder {
     val view = LayoutInflater.from(parent.context)
        .inflate(R.layout.fragment_movie,parent,false)
        return MovieListViewHolder(view)
    }
    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        val item = adapterMoviesList[position]
        holder.itemView.setOnClickListener {
            callback.startMovieDetailsFragment(item)
        }

        holder.setRate(item.ratings)
        holder.genere.text = setGenres(item.genres)
        holder.title.text = item.title
        holder.reviews.text = "${item.numberOfRatings} reviews"
        holder.time.text = "${item.runtime} min"
        holder.tv_age.text = "+${item.minimumAge}"
        holder.isliked.setOnClickListener {
                    holder.isliked.setImageDrawable(
                        ContextCompat.getDrawable(
                                holder.itemView.context,
                                R.drawable.ic_liked
                        )
                    )
        }
        Glide
            .with(holder.itemView)
            .load(item.poster)
            .centerCrop()
                .placeholder(R.drawable.arrow)
            .into(holder.poster)
    }
    fun initCallback(callback: FragmentMoviesList) {
        this.callback = callback
    }
    interface Callback {
        fun startMovieDetailsFragment(movie: Movie)
    }
    fun setItems (items: List<Movie>){
        adapterMoviesList.clear()
        adapterMoviesList.addAll(items)
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return adapterMoviesList.size
    }
    private fun setGenres(genres: List<Genre>): String{
        var genresStr = ""
        for (i in genres.indices){
            genresStr += if (i == genres.size-1){
                genres[i].name
            } else {
                "${genres[i].name}, "
            }
        }
        return genresStr
    }
}
