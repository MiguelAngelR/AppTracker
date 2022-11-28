package com.mike.network_module.mapper

import com.mike.core.entity.model.PopularMovie
import com.mike.network_module.dto.response.PopularMoviesNetworkResponse

internal fun PopularMoviesNetworkResponse.asPopularMoviesDomainList() : List<PopularMovie> =
        this.results.map {
            PopularMovie(
                adult= it.adult,
                backdropPath = it.backdropPath,
                genreIds = it.genreIds,
                id = it.id,
                originalLanguage = it.originalLanguage,
                originalTitle = it.originalTitle,
                overview = it.overview,
                popularity = it.popularity,
                posterPath = it.posterPath,
                releaseDate = it.releaseDate,
                title = it.title,
                video = it.video,
                voteAverage = it.voteAverage,
                voteCount = it.voteCount
            )
        }

