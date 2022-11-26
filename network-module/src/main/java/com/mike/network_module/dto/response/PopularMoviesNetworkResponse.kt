package com.mike.network_module.dto.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
internal data class PopularMoviesNetworkResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val results: List<ResultNetwork>,
    @SerializedName("total_pages")val totalPages: Int,
    @SerializedName("total_results") val totalResults: Int
)