package com.maghfira_m.mymoviecatalogue.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.maghfira_m.mymoviecatalogue.core.domain.model.Movie
import com.maghfira_m.mymoviecatalogue.core.domain.usecase.MovieUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailMovieViewModel(private val movieUseCase: MovieUseCase) : ViewModel() {

    fun checkFavoriteMovie(movieId: String) = movieUseCase.checkFavoriteMovie(movieId).asLiveData()

    fun insertFavoriteMovie(movie: Movie) {
        CoroutineScope(Dispatchers.Main).launch {
            movieUseCase.insertFavoriteMovie(movie)
        }
    }

    fun deleteFavoriteMovie(movie: Movie) {
        CoroutineScope(Dispatchers.Main).launch {
            movieUseCase.deleteFavoriteMovie(movie)
        }
    }
}