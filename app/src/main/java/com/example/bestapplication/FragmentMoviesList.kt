package com.example.bestapplication

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bestapplication.data.Movie
import com.example.bestapplication.data.loadMovies
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class FragmentMoviesList : Fragment(), MovieListAdapter.Callback {
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_movies_list, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val scope = CoroutineScope(Dispatchers.IO)
        var movieList = listOf<Movie>()
        scope.launch {
            movieList = loadMovies(requireActivity())
        }

        val recyclerView = view.findViewById<RecyclerView>(R.id.movies_detals)
        val moviesListAdapter = MovieListAdapter()
        moviesListAdapter.initCallback(this)
        recyclerView.adapter = moviesListAdapter
        moviesListAdapter.setItems(movieList)
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            recyclerView.layoutManager = GridLayoutManager(context, 2)
        } else {
            recyclerView.layoutManager = GridLayoutManager(context, 4)
        }
    }

    override fun startMovieDetailsFragment() {
        fragmentManager
                ?.beginTransaction()
                ?.replace(R.id.fragment_container, FragmentMoviesDetails())
                ?.addToBackStack(null)
                ?.commit()
    }
}
