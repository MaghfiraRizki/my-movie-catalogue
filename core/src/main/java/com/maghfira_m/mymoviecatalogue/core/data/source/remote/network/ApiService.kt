package com.maghfira_m.mymoviecatalogue.core.data.source.remote.network

import com.maghfira_m.mymoviecatalogue.core.data.source.remote.response.ListMovieResponse
import com.maghfira_m.mymoviecatalogue.core.data.source.remote.response.MovieResponse
import com.maghfira_m.mymoviecatalogue.core.utils.Config
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("discover/movie?api_key=" + Config.API_KEY)
    suspend fun getAllMovies(): ListMovieResponse

    @GET("movie/{id}")
    suspend fun getDetailMovie(
        @Path("id") id: String,
        @Query("api_key") apiKey: String
    ): MovieResponse
}