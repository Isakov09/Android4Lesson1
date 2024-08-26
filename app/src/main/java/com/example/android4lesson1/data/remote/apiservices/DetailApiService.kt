package com.example.android4lesson1.data.remote.apiservices

import android.telecom.Call
import com.example.android4lesson1.data.remote.models.DetailResponse
import retrofit2.http.GET
import retrofit2.http.Path

private const val DETAIL_END_POINT_MANGA = "manga/{id}"

interface DetailApiService {
//    @GET(DETAIL_END_POINT_MANGA)
//    fun getAnimeById(
//        @Path("id") id: Int
//    ): retrofit2.Call<DetailResponse>
}