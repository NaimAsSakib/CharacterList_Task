package com.example.characterlisttask.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.characterlisttask.api.models.CharacterListResponse
import com.example.characterlisttask.ui.list.CharacterListRepository
import kotlinx.coroutines.launch

class DetailsViewModel: ViewModel() {
    private val repository = DetailsRepository()

    private val _characterListResponse = MutableLiveData<CharacterListResponse>()
    val characterListResponse : LiveData<CharacterListResponse> get() = _characterListResponse

    fun getDetails(id: String){
        viewModelScope.launch {
            try {
                val response = repository.getDetails(id)
                _characterListResponse.value = response
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    }
}