package com.example.bestapplication.movielist

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bestapplication.moviedetails.FragmentMoviesDetails
import com.example.bestapplication.R
import com.example.bestapplication.data.model.Genre
import com.example.bestapplication.data.model.MoviePreview
import kotlinx.android.synthetic.main.fragment_movies_list.*

class FragmentMoviesList : Fragment(), MovieListAdapter.Callback {

    private var genreList = listOf<Genre>()
    private val viewModel by viewModels<MovieListViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movies_list, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.getGenres(requireActivity())
        initObservers()
    }

    private fun initObservers() {
        viewModel.filmsLiveData.observe(viewLifecycleOwner, { movies ->
            val moviesListAdapter = MovieListAdapter(movies, genreList)
            moviesListAdapter.initCallback(this)
            movies_detals.adapter = moviesListAdapter
            if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                movies_detals.layoutManager = GridLayoutManager(context, 2)
            } else {
                movies_detals.layoutManager = GridLayoutManager(context, 4)
            }
        })

        viewModel.genresLiveData.observe(viewLifecycleOwner, {
            it?: return@observe
            genreList = it
            viewModel.getFilms(requireActivity())
        })
    }


    override fun startMovieDetailsFragment(item: MoviePreview) {
        fragmentManager
            ?.beginTransaction()
            ?.replace(R.id.fragment_container, FragmentMoviesDetails.newInstance(item.id))
            ?.addToBackStack(null)
            ?.commit()
    }
}

