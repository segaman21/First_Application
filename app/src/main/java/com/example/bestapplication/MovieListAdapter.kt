package com.example.bestapplication

import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
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
        holder.itemView.setOnClickListener {
            callback.startMovieDetailsFragment()
        }
        val item = adapterMoviesList[position]
        holder.setRate(item.ratings)
        holder.genere.text = item.genres.toString()
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
            .into(holder.poster)
    }
    fun initCallback(callback: FragmentMoviesList) {
        this.callback = callback
    }
    interface Callback {
        fun startMovieDetailsFragment()
    }
    fun setItems (items: List<Movie>){
        adapterMoviesList.clear()
        adapterMoviesList.addAll(items)
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return adapterMoviesList.size
    }
}
