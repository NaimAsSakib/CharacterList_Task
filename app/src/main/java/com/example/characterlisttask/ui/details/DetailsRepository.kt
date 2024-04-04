package com.example.characterlisttask.ui.details

import com.example.characterlisttask.api.end_points.RetrofitClient
import com.example.characterlisttask.api.models.CharacterListResponse

class DetailsRepository {
    private val apiService = RetrofitClient.apiService

    suspend fun getDetails(id: String): CharacterListResponse {
        return apiService.getDetails(id)
    }
}