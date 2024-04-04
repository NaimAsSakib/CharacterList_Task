package com.example.characterlisttask.api.end_points

import com.example.characterlisttask.api.models.CharacterListResponse
import retrofit2.http.GET

interface ApiService {
        @GET("characters")
        suspend fun getCharacters(): CharacterListResponse
    }