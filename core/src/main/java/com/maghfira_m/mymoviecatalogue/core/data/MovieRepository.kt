package com.maghfira_m.mymoviecatalogue.core.data

import com.maghfira_m.mymoviecatalogue.core.data.source.local.LocalDataSource
import com.maghfira_m.mymoviecatalogue.core.data.source.remote.RemoteDataSource
import com.maghfira_m.mymoviecatalogue.core.data.source.remote.network.ApiResponse
import com.maghfira_m.mymoviecatalogue.core.domain.model.Movie
import com.maghfira_m.mymoviecatalogue.core.domain.repository.IMovieRepository
import com.maghfira_m.mymoviecatalogue.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class MovieRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : IMovieRepository {
    override fun getAllMovies(): Flow<Resource<List<Movie>>> = flow {
        emit(Resource.Loading())
        when (val apiResponse = remoteDataSource.getAllMovies().first()) {
            is ApiResponse.Success -> {
                emit(Resource.Success(DataMapper.mapResponsesToDomain(apiResponse.data)))
            }
        }
    }

    override fun getFavoriteMovie(): Flow<List<Movie>> =
        localDataSource.getFavoriteMovie().map { DataMapper.mapEntitiesToDomain(it) }

    override suspend fun insertFavoriteMovie(movie: Movie) {
        val movieEntity = DataMapper.mapDomainToEntity(movie)
        localDataSource.insertFavoriteMovie(movieEntity)
    }

    override suspend fun deleteFavoriteMovie(movie: Movie) {
        val movieEntity = DataMapper.mapDomainToEntity(movie)
        localDataSource.deleteFavoriteMovie(movieEntity)
    }

    override fun checkFavoriteMovie(movieId: String): Flow<Int> =
        localDataSource.checkFavoriteMovie(movieId)

}