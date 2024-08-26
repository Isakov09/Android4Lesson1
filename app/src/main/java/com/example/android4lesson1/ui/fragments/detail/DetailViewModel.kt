package com.example.android4lesson1.ui.fragments.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android4lesson1.data.remote.models.DataItem
import com.example.android4lesson1.data.repositories.KitsuRepository
import com.example.android4lesson1.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

//
//@HiltViewModel
//class DetailViewModel @Inject constructor(
//    private val savedStateHandle: SavedStateHandle,
//    private val detailKitsuApi: KitsuRepository,
//) : ViewModel() {
//
//    private val _detailState = MutableLiveData<UiState<DataItem>>()
//    val detailState: LiveData<UiState<DataItem>> get() = _detailState
//    private val id = savedStateHandle.get<String>(ID_KEY)
//
//    fun setId(id: String) {
//        savedStateHandle[ID_KEY] = id
//    }
//
//    init {
//        getAnimeById()
//    }
//
//    private fun getAnimeById() {
//        _detailState.value = UiState.Loading
//
//        Thread {
//            try {
//                id?.let {
//                    val response = detailKitsuApi.detailAnime(it.toInt()).execute()
//
//                    if (response.isSuccessful) {
//                        _detailState.postValue(UiState.Success())
//                    } else {
//                        _detailState.postValue(UiState.Error(Exception(response.errorBody()?.string() ?: "Unknown error"), "Error"))
//                    }
//                }
//            } catch (e: Exception) {
//                _detailState.postValue(UiState.Error(e, e.message ?: "Unknown error"))
//            }
//        }.start()
//    }
//
//    companion object {
//        private const val ID_KEY = "id"
//    }
//}