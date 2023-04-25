package com.example.composerickandmorty.ui.data.repository

import com.example.composerickandmorty.ui.data.model.characters.CharactersModel
import com.example.composerickandmorty.ui.data.model.characters.ResultModel

class FakeRepository:Repository {

    private val cartoonChars =  mutableListOf<ResultModel?>()

    override suspend fun getCharacters(): CharactersModel {
        return cartoonChars.toList()
    }
    fun addCartoonCharstoList(newCartoonChars: List<ResultModel>) {
        cartoonChars.addAll(newCartoonChars)
    }

    fun clearcCartoonCharsList() {
        cartoonChars.clear()
    }
}