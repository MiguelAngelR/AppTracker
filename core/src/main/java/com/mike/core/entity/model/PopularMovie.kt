package com.mike.core.entity.model

data class PopularMovie(
    val adult: Boolean? = true,
    val backdropPath: String?,
    val genreIds: List<Int>,
    val id: Int,
    val originalLanguage: String?,
    val originalTitle: String?,
    val overview: String?,
    val popularity: Double? = null,
    val posterPath: String?,
    val releaseDate: String?,
    val title: String?,
    val video: Boolean? = null,
    val voteAverage: Double? = null,
    val voteCount: Int? = null
)