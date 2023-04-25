package com.example.composerickandmorty.ui.data.remote

import com.example.composerickandmorty.ui.data.model.characters.CharactersModel
import com.example.composerickandmorty.ui.data.model.characters.ResultModel
import retrofit2.http.GET

interface ApiRequest {
    @GET(ApiDetails.Characters_ENDPOINT)
    suspend fun getCharacters(): CharactersModel
}