package com.maghfira_m.mymoviecatalogue.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class Genre(
    @field:SerializedName("id")
    val genreId: String? = null,

    @field:SerializedName("name")
    val name: String? = null
)
