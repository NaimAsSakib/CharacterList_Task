package com.example.characterlisttask.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.characterlisttask.api.models.CharacterListResponse
import kotlinx.coroutines.launch

class CharacterListViewModel: ViewModel() {
    private val repository = CharacterListRepository()

    private val _characterListResponse = MutableLiveData<CharacterListResponse>()
    val characterListResponse : LiveData<CharacterListResponse> get() = _characterListResponse

    fun getCharacters(){
        viewModelScope.launch {
            try {
                val response = repository.getCharacters()
                _characterListResponse.value = response
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    }
}