package com.example.composerickandmorty.data.repository

import com.example.composerickandmorty.data.model.characters.CharactersModel
import com.example.composerickandmorty.data.model.characters.ResultModel
import com.example.composerickandmorty.data.remote.ApiRequest
import javax.inject.Inject

class RepositoryImpl@Inject constructor(
    val apiRequest: ApiRequest
): Repository {
    override suspend fun getCharacters(): CharactersModel = apiRequest.getCharacters()
}