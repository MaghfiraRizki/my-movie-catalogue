package com.maghfira_m.mymoviecatalogue.core.domain.repository

import com.maghfira_m.mymoviecatalogue.core.data.Resource
import com.maghfira_m.mymoviecatalogue.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {

    fun getAllMovies(): Flow<Resource<List<Movie>>>

    fun getFavoriteMovie(): Flow<List<Movie>>

    fun insertFavoriteMovie(movie: Movie)

    fun deleteFavoriteMovie(movie: Movie)

    fun checkFavoriteMovie(movieId: String)
}