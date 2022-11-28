package com.mike.network_module.service

import androidx.annotation.Keep
import com.mike.network_module.dto.response.PopularMoviesNetworkResponse
import com.mike.network_module.utils.API_RELATIVE_URL
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

@Keep
internal interface MoviesService {

    @GET("$API_RELATIVE_URL/movie/popular")
    suspend fun fetchPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: String
    ) : PopularMoviesNetworkResponse

}