package com.maghfira_m.mymoviecatalogue.core.data.source.local

import com.maghfira_m.mymoviecatalogue.core.data.source.local.entity.MovieEntity
import com.maghfira_m.mymoviecatalogue.core.data.source.local.room.MovieDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val movieDao: MovieDao) {

    fun getFavoriteMovie(): Flow<List<MovieEntity>> = movieDao.getFavoriteMovie()

    suspend fun insertFavoriteMovie(movie: MovieEntity) = movieDao.insertFavoriteMovie(movie)

    suspend fun deleteFavoriteMovie(movie: MovieEntity) = movieDao.deleteFavoriteMovie(movie)

    fun checkFavoriteMovie(movieId: String) = movieDao.checkFavoriteMovie(movieId)
}