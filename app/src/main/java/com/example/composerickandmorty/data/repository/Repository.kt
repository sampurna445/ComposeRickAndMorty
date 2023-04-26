package com.example.composerickandmorty.data.repository

import com.example.composerickandmorty.data.model.characters.CharactersModel
import com.example.composerickandmorty.data.model.characters.ResultModel

interface Repository {
    suspend fun getCharacters(): CharactersModel
}