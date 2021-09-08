package com.maghfira_m.mymoviecatalogue.core.domain.usecase

import com.maghfira_m.mymoviecatalogue.core.domain.model.Movie
import com.maghfira_m.mymoviecatalogue.core.domain.repository.IMovieRepository

class MovieInteractor(private val movieRepository: IMovieRepository) : MovieUseCase {
    override fun getAllMovies() = movieRepository.getAllMovies()

    override fun getFavoriteMovie() = movieRepository.getFavoriteMovie()

    override suspend fun insertFavoriteMovie(movie: Movie) =
        movieRepository.insertFavoriteMovie(movie)

    override suspend fun deleteFavoriteMovie(movie: Movie) =
        movieRepository.deleteFavoriteMovie(movie)

    override fun checkFavoriteMovie(movieId: String) = movieRepository.checkFavoriteMovie(movieId)
}