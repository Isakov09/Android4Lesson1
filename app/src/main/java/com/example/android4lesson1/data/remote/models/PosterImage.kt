package com.example.android4lesson1.data.remote.models

import com.google.gson.annotations.SerializedName

data class PosterImage(
    @SerializedName("small")
    val small: String = "",
    @SerializedName("original")
    val original: String = "",
    @SerializedName("large")
    val large: String = "",
    @SerializedName("tiny")
    val tiny: String = "",
    @SerializedName("meta")
    val meta: Meta,
    @SerializedName("medium")
    val medium: String = ""
)