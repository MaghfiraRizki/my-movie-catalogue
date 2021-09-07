package com.maghfira_m.mymoviecatalogue.core.utils

import com.maghfira_m.mymoviecatalogue.core.data.source.local.entity.MovieEntity
import com.maghfira_m.mymoviecatalogue.core.data.source.remote.response.MovieResponse
import com.maghfira_m.mymoviecatalogue.core.domain.model.Movie

object DataMapper {
    fun mapResponsesToDomain(input: List<MovieResponse>): List<Movie> = input.map {
        Movie(
            movieId = it.movieId,
            title = it.title,
            tagLine = it.tagLine,
            overview = it.overview,
            releaseDate = it.releaseDate,
            voteAverage = it.voteAverage,
            posterPath = it.posterPath
        )
    }

    fun mapEntitiesToDomain(input: List<MovieEntity>): List<Movie> = input.map {
        Movie(
            movieId = it.movieId,
            title = it.title,
            tagLine = it.tagLine,
            overview = it.overview,
            releaseDate = it.releaseDate,
            voteAverage = it.voteAverage,
            posterPath = it.posterPath
        )
    }

    fun mapDomainToEntity(input: Movie) = MovieEntity(
        movieId = input.movieId,
        title = input.title,
        tagLine = input.tagLine,
        overview = input.overview,
        releaseDate = input.releaseDate,
        voteAverage = input.voteAverage,
        posterPath = input.posterPath
    )
}