package com.example.android4lesson1.data.remote.apiservices

import com.example.android4lesson1.data.remote.models.DetailResponse
import com.example.android4lesson1.data.remote.models.KitsuResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val ANIME_END_POINT = "anime"
private const val DETAIL_END_POINT_ANIME = "anime/{id}"

interface KitsuApiService {

        @GET(ANIME_END_POINT)
        fun getAnime(
            @Query("page[limit]") limit: Int = 20,
            @Query("page[offset]") offset: Int = 0
        ): Call<KitsuResponse>
    @GET(DETAIL_END_POINT_ANIME)
    fun getAnimeById(
        @Path("id") id: Int
    ): Call<DetailResponse>
}