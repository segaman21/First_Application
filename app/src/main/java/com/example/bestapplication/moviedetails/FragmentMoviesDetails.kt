package com.example.bestapplication.moviedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.bestapplication.R
import com.example.bestapplication.data.Actor
import com.example.bestapplication.data.Genre
import kotlinx.android.synthetic.main.fragment_movies_details.*
import com.example.bestapplication.data.Movie as Movie

class FragmentMoviesDetails : Fragment() {
    private val viewModel = MovieDetailsViewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movies_details, container, false)

        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val movie = arguments?.getParcelable<Movie>(MOVIE_ID)
        initListeners()
        movie?.let{bind(it)}
    }


    private fun bind(movie: Movie) {
        setRate(movie!!.ratings)
        Glide.with(requireActivity())
            .load(movie.backdrop)
            .placeholder(R.drawable.arrow)
            .centerCrop()
            .into(imageView_title)
        textView_age.text = "${movie.minimumAge.toString()} +"
        tv_title_movie.text = movie.title
        reviews_film.text = "${movie.numberOfRatings} reviews"
        textView_story.text = movie.overview
        textView_genre.text = movie.genres.let { setGenres(it) }

        val actorAdapter = ActorAdapter()
        recycler_name.adapter = actorAdapter
        recycler_name.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        actorAdapter.setItems(movie.actors)
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

    private fun setRate(rate: Float) {
        if (rate >= 2F) {
            setRedStar(imageView_star_one)
        } else {
            setGrayStar(imageView_star_one)
        }
        if (rate >= 4F) {
            setRedStar(imageView_star_two)
        } else {
            setGrayStar(imageView_star_two)
        }
        if (rate >= 6F) {
            setRedStar(imageView_star_three)
        } else {
            setGrayStar(imageView_star_three)
        }
        if (rate >= 8F) {
            setRedStar(imageView_star_four)
        } else {
            setGrayStar(imageView_star_four)
        }
        if (rate == 10F) {
            setRedStar(imageView_star_five)
        } else {
            setGrayStar(imageView_star_five)
        }

    }

    private fun setGrayStar(starView: ImageView) {
        starView.setImageDrawable(
            ContextCompat.getDrawable(
                requireActivity(),
                R.drawable.star_gray
            )
        )
    }

    private fun setRedStar(starView: ImageView) {
        starView.setImageDrawable(
            ContextCompat.getDrawable(
                requireActivity(),
                R.drawable.star_red
            )
        )
    }

    private fun initListeners() {
        imageView_back.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    companion object {
        private const val MOVIE_ID = "movie"
        fun newInstance(movie: Movie?): FragmentMoviesDetails {
            val fragment = FragmentMoviesDetails()
            val args = Bundle()
            args.putParcelable(MOVIE_ID, movie)
            fragment.arguments = args
            return fragment
        }
    }
}
