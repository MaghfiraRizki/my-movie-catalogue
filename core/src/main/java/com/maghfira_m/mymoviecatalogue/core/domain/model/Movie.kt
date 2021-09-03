package com.maghfira_m.mymoviecatalogue.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val movieId: String,
    val title: String? = null,
    val tagLine: String? = null,
    val overview: String? = null,
    val releaseDate: String? = null,
    val runtime: String? = null,
    val voteAverage: Double? = null,
    val posterPath: String? = null
) : Parcelable
