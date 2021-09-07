package com.maghfira_m.mymoviecatalogue.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.maghfira_m.mymoviecatalogue.core.domain.usecase.MovieUseCase

class MovieViewModel(movieUseCase: MovieUseCase) : ViewModel() {

    val movies = movieUseCase.getAllMovies().asLiveData()
}