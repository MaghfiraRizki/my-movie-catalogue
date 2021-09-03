package com.maghfira_m.mymoviecatalogue.core.data.source.remote

import androidx.lifecycle.MutableLiveData
import com.maghfira_m.mymoviecatalogue.core.data.source.remote.network.ApiResponse
import com.maghfira_m.mymoviecatalogue.core.data.source.remote.network.ApiService
import com.maghfira_m.mymoviecatalogue.core.data.source.remote.response.MovieResponse
import com.maghfira_m.mymoviecatalogue.core.utils.Config
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {

    fun getAllMovies(): Flow<ApiResponse<List<MovieResponse>>> {
        val resultData = MutableLiveData<ApiResponse<List<MovieResponse>>>()

        //get data from remote API
        return flow {
            try {
                val response = apiService.getAllMovies()
                val dataArray = response.results
                if (dataArray.isEmpty()) {
                    emit(ApiResponse.Empty)
                } else {
                    emit(ApiResponse.Success(dataArray))
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    fun getDetailMovie(id: String): Flow<ApiResponse<MovieResponse>> {
        return flow {
            try {
                val response = apiService.getDetailMovie(id, Config.API_KEY)
                emit(ApiResponse.Success(response))
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }
    }
}