package com.example.android4lesson1.data.repositories

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.android4lesson1.data.remote.apiservices.DetailApiService
import com.example.android4lesson1.data.remote.apiservices.KitsuApiService

import com.example.android4lesson1.data.remote.models.DataItem
import com.example.android4lesson1.data.remote.models.DetailResponse
import com.example.android4lesson1.data.remote.models.KitsuResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Call
import javax.inject.Inject

class KitsuRepository @Inject constructor(
    private val kitsuApiService: KitsuApiService
) {

    fun fetchAnime(): Call<KitsuResponse> {
        // Вызываем API и возвращаем объект Call для выполнения сетевого запроса
        return kitsuApiService.getAnime()
    }

    fun detailAnime(id: Int): Call<DetailResponse> {
        return kitsuApiService.getAnimeById(id)
    }
}