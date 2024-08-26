package com.example.android4lesson1.ui.fragments.anime

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android4lesson1.data.remote.models.KitsuResponse
import com.example.android4lesson1.data.repositories.KitsuRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class AnimeViewModel @Inject constructor(
    private val repository: KitsuRepository
) : ViewModel() {

    private val _animeLiveData = MutableLiveData<KitsuResponse>()
    val animeLiveData: LiveData<KitsuResponse> get() = _animeLiveData

    fun fetchAnime() {
        // Выполнение сетевого запроса в фоновом потоке
        Thread {
            try {
                val call = repository.fetchAnime()
                val response = call.execute()
                if (response.isSuccessful) {
                    _animeLiveData.postValue(response.body())
                } else {
                    Log.e("AnimeViewModel", "Ошибка при загрузке аниме: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                Log.e("AnimeViewModel", "Исключение при загрузке аниме", e)
            }
        }.start()
    }
}