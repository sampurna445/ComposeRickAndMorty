package com.example.composerickandmorty.ui.data.repository

import com.example.composerickandmorty.ui.data.model.characters.CharactersModel
import com.example.composerickandmorty.ui.data.model.characters.ResultModel
import com.example.composerickandmorty.ui.data.remote.ApiRequest
import javax.inject.Inject

class RepositoryImpl@Inject constructor(
    val apiRequest: ApiRequest
):Repository{
    override suspend fun getCharacters():CharactersModel = apiRequest.getCharacters()
}