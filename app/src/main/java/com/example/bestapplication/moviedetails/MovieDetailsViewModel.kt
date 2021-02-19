package com.example.bestapplication.moviedetails

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bestapplication.data.Actor
import com.example.bestapplication.data.Movie
import com.example.bestapplication.data.loadMovies
import kotlinx.coroutines.*


class MovieDetailsViewModel : ViewModel() {
    private val _moviesLiveData = MutableLiveData<List<Movie>>()
    val moviesLiveData: LiveData<List<Movie>> get() = _moviesLiveData
    private val _actorsLiveData = MutableLiveData<List<Actor>>()
    val actorsLiveData: LiveData<List<Actor>> get() = _actorsLiveData


    fun getMovies(context: Context, movieId: Int) {
        viewModelScope.launch { _moviesLiveData.value = loadMovies(context) }
    }


}