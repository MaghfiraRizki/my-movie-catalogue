package com.maghfira_m.mymoviecatalogue.detail

import androidx.lifecycle.ViewModel
import com.maghfira_m.mymoviecatalogue.core.domain.usecase.MovieUseCase

class DetailMovieViewModel(private val movieUseCase: MovieUseCase) : ViewModel() {

    fun checkFavoriteMovie(movieId: String) = movieUseCase.checkFavoriteMovie(movieId)
}