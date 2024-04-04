package com.example.characterlisttask.api.end_points

import com.example.characterlisttask.api.models.CharacterResponse
import retrofit2.http.GET

interface ApiService {
    interface ApiService {
        @GET("characters")
        suspend fun getCharacters(): List<CharacterResponse>
    }

}