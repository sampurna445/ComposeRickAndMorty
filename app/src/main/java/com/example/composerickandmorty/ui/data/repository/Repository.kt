package com.example.composerickandmorty.ui.data.repository

import com.example.composerickandmorty.ui.data.model.characters.CharactersModel
import com.example.composerickandmorty.ui.data.model.characters.ResultModel

interface Repository {
    suspend fun getCharacters():CharactersModel
}