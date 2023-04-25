package com.example.composerickandmorty.ui.data.model.characters


import com.google.gson.annotations.SerializedName

data class InfoModel(
    @SerializedName("count")
    val count: Int? = 0,
    @SerializedName("next")
    val next: String? = "",
    @SerializedName("pages")
    val pages: Int? = 0,
   // @SerializedName("prev")
  //  val prev: AnyModel? = AnyModel()
)