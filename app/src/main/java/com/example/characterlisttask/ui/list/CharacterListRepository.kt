package com.example.characterlisttask.ui.list

import com.example.characterlisttask.api.end_points.RetrofitClient
import com.example.characterlisttask.api.models.CharacterListResponse

class CharacterListRepository {
    private val apiService = RetrofitClient.apiService

    suspend fun getCharacters(): CharacterListResponse{
        return apiService.getCharacters()
    }
}