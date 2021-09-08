package com.maghfira_m.mymoviecatalogue.core.data.source.remote.network

import com.maghfira_m.mymoviecatalogue.core.data.source.remote.response.ListMovieResponse
import com.maghfira_m.mymoviecatalogue.core.utils.Config
import retrofit2.http.GET

interface ApiService {
    @GET("discover/movie?api_key=" + Config.API_KEY)
    suspend fun getAllMovies(): ListMovieResponse
}