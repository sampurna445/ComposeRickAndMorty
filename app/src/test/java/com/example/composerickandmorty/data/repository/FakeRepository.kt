package com.example.composerickandmorty.data.repository

import com.example.composerickandmorty.data.model.characters.CharactersModel
import com.example.composerickandmorty.data.model.characters.InfoModel
import com.example.composerickandmorty.data.model.characters.ResultModel
import com.example.composerickandmorty.data.repository.Repository

class FakeRepository: Repository {

    private val cartoonChars =  mutableListOf<ResultModel?>()

   override suspend fun getCharacters(): CharactersModel {
       val charCartoon = CharactersModel(
           InfoModel(),
           listOf(
               ResultModel(id =1, name = " Rick Sanchez", status = "Alive"),
               ResultModel(id =2, name = " Morty Smith", status = "Alive"),
               ResultModel(id =3, name = " Summer Smith", status = "Alive")
           )
       )
        return charCartoon
    }
    fun addCartoonCharstoList(newCartoonChars: List<ResultModel>) {
        cartoonChars.addAll(newCartoonChars)
    }

    fun clearcCartoonCharsList() {
        cartoonChars.clear()
    }

  /*  override suspend fun getCharacters(): CharactersModel {
        TODO("Not yet implemented")
    }*/
}