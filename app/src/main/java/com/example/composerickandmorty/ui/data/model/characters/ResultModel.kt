package com.example.composerickandmorty.ui.data.model.characters


import com.google.gson.annotations.SerializedName

data class ResultModel(
    @SerializedName("created")
    val created: String? = "",
    @SerializedName("episode")
    val episode: List<String?>? = listOf(),
    @SerializedName("gender")
    val gender: String? = "",
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("image")
    val image: String? = "",
    @SerializedName("location")
    val location: LocationModel? = LocationModel(),
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("origin")
    val origin: OriginModel? = OriginModel(),
    @SerializedName("species")
    val species: String? = "",
    @SerializedName("status")
    val status: String? = "",
    @SerializedName("type")
    val type: String? = "",
    @SerializedName("url")
    val url: String? = ""
)