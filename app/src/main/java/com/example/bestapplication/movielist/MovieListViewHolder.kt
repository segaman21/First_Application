package com.example.bestapplication.movielist

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bestapplication.R
import com.example.bestapplication.data.model.Genre
import com.example.bestapplication.data.model.MoviePreview

class MovieListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val title = itemView.findViewById<TextView>(R.id.movie_name)
    val time = itemView.findViewById<TextView>(R.id.time)
    val tv_age = itemView.findViewById<TextView>(R.id.tv_age)
    val isliked = itemView.findViewById<ImageView>(R.id.isliked)
    val poster = itemView.findViewById<ImageView>(R.id.ImageView_mask)
    val genere = itemView.findViewById<TextView>(R.id.genere)
    val reviews = itemView.findViewById<TextView>(R.id.how_reviews)
    val first_star = itemView.findViewById<ImageView>(R.id.first_star)
    val second_star = itemView.findViewById<ImageView>(R.id.second_star)
    val thrid_star = itemView.findViewById<ImageView>(R.id.thrid_star)
    val four_star = itemView.findViewById<ImageView>(R.id.four_star)
    val five_star = itemView.findViewById<ImageView>(R.id.five_star)

    fun onBind(item: MoviePreview, genreList: List<Genre>, callback: MovieListAdapter.Callback) {
        itemView.setOnClickListener {
            callback.startMovieDetailsFragment(item)
        }
        val genres = mutableListOf<Genre>()
        for (i in 0 until item.genres.size) {
            val genre = genreList.firstOrNull { it.id == item.genres[i] }
            if (genre != null) {
                genres.add(genre)
            }
        }
        setRate(item.ratings)
        genere.text = setGenres(genres)
        title.text = item.title
        reviews.text = "${item.numberOfRatings} reviews"
//    time.text = "${item.runtime} min"
        tv_age.text = if (item.minimumAge) "+16" else "+13"
        isliked.setOnClickListener {
            isliked.setImageDrawable(
                ContextCompat.getDrawable(
                    itemView.context,
                    R.drawable.ic_liked
                )
            )
        }
        val posterUrl = "https://image.tmdb.org/t/p/original/${item.poster}"
        Glide.with(itemView)
            .load(posterUrl)
            .centerCrop()
            .placeholder(R.drawable.arrow)
            .into(poster)
    }


    fun setRate(rate: Float) {
        if (rate >= 2.0F) {
            setRedStar(first_star)
        } else {
            setGrayStar(first_star)
        }

        if (rate >= 4.0F) {
            setRedStar(second_star)
        } else {
            setGrayStar(second_star)
        }

        if (rate >= 6.0F) {
            setRedStar(thrid_star)
        } else {
            setGrayStar(thrid_star)
        }

        if (rate >= 8.0F) {
            setRedStar(four_star)
        } else {
            setGrayStar(four_star)
        }

        if (rate == 10.0F) {
            setRedStar(five_star)
        } else {
            setGrayStar(five_star)
        }

        if (rate > 10)
            throw IllegalStateException("Illegal rating value")
    }

    private fun setGrayStar(starView: ImageView) {
        starView.setImageDrawable(
            ContextCompat.getDrawable(
                itemView.context,
                R.drawable.small_gray
            )
        )
    }

    private fun setRedStar(starView: ImageView) {
        starView.setImageDrawable(
            ContextCompat.getDrawable(
                itemView.context,
                R.drawable.small_red
            )
        )
    }

    private fun setGenres(genres: List<Genre>): String {
        var genresStr = ""
        for (i in genres.indices) {
            genresStr += if (i == genres.size - 1) {
                genres[i].name
            } else {
                "${genres[i].name}, "
            }
        }
        return genresStr
    }
}