package com.maghfira_m.mymoviecatalogue.core.data.source.local.room

import androidx.room.*
import com.maghfira_m.mymoviecatalogue.core.data.source.local.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Query("SELECT * FROM movies")
    fun getFavoriteMovie(): Flow<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteMovie(movie: MovieEntity)

    @Delete
    suspend fun deleteFavoriteMovie(movie: MovieEntity)

    @Query("SELECT COUNT(movieId) FROM movies WHERE movieId = :movieId")
    fun checkFavoriteMovie(movieId: String): Flow<Int>
}