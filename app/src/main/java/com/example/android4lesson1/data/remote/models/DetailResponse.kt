package com.example.android4lesson1.data.remote.models

import com.google.gson.annotations.SerializedName

data class DetailResponse(
    @SerializedName("data")
    val data: DataItem
)