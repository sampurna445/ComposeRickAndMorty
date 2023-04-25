package com.example.composerickandmorty.ui.data.remote

import com.example.composerickandmorty.ui.data.model.characters.CharactersModel
import com.example.composerickandmorty.ui.data.model.characters.ResultModel
import com.example.composerickandmorty.ui.data.remote.ApiRequest

class FakeApiRequest : ApiRequest {
    private var mockedResponse: CharactersModel? = null
    private var mockedError: Boolean = false

    fun setMockedResponse(cartoonChars: CharactersModel) {
        mockedResponse = cartoonChars
        mockedError = false
    }


    override suspend fun getCharacters(): CharactersModel {
        return if (mockedError) {
            throw Exception("Error fetching cartoon characters list")
        } else {
            mockedResponse ?: CharactersModel()
        }
    }
}