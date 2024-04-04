package com.example.characterlisttask.api.end_points

import com.example.characterlisttask.api.models.CharacterListResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("characters")
    suspend fun getCharacters(): CharacterListResponse

    @GET("character/{id}")
    suspend fun getDetails(@Path("id") id: String): CharacterListResponse

}