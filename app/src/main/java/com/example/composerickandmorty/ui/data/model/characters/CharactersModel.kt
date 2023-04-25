package com.example.composerickandmorty.ui.data.model.characters


import com.google.gson.annotations.SerializedName

data class CharactersModel(
    @SerializedName("info")
    val info: InfoModel? = InfoModel(),
    @SerializedName("results")
    val results: List<ResultModel?>? = listOf()
)