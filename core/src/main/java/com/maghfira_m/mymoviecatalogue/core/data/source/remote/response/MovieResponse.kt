package com.maghfira_m.mymoviecatalogue.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @field:SerializedName("id")
    val movieId: String,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("tagline")
    val tagLine: String? = null,

    @field:SerializedName("overview")
    val overview: String? = null,

    @field:SerializedName("release_date")
    val releaseDate: String? = null,

    @field:SerializedName("vote_average")
    val voteAverage: Double? = null,

    @field:SerializedName("poster_path")
    val posterPath: String? = null
)
