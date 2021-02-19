package com.example.bestapplication.movielist

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bestapplication.data.Movie
import com.example.bestapplication.data.loadMovies

import kotlinx.coroutines.launch

class MovieListViewModel : ViewModel() {
    private val _filmsLiveData = MutableLiveData<List<Movie>>()
    val filmsLiveData: LiveData<List<Movie>> get() = _filmsLiveData

    fun getFilms(context: Context) {
        viewModelScope.launch { _filmsLiveData.value = loadMovies(context) }
    }
}