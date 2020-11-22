package com.battagliandrea.marvelapi.feature.characters.data.model

import com.google.gson.annotations.SerializedName

internal data class CharacterEventsDataModel(
    @SerializedName("available")
    val available: Int? = 0,
    @SerializedName("collectionURI")
    val collectionURI: String? = "",
    @SerializedName("items")
    val items: List<Item?>? = listOf(),
    @SerializedName("returned")
    val returned: Int? = 0
) {
    data class Item(
        @SerializedName("name")
        val name: String? = "",
        @SerializedName("resourceURI")
        val resourceURI: String? = ""
    )
}
