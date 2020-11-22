package com.battagliandrea.marvelapi.feature.characters.data.retrofit

import com.battagliandrea.marvelapi.feature.characters.data.model.CharacterDataModel
import com.google.gson.annotations.SerializedName

internal data class GetCharactersResponse(
    @SerializedName("attributionHTML")
    val attributionHTML: String? = "",
    @SerializedName("attributionText")
    val attributionText: String? = "",
    @SerializedName("code")
    val code: Int? = 0,
    @SerializedName("copyright")
    val copyright: String? = "",
    @SerializedName("data")
    val `data`: Data? = Data(),
    @SerializedName("etag")
    val etag: String? = "",
    @SerializedName("status")
    val status: String? = ""
) {
    data class Data(
        @SerializedName("count")
        val count: Int? = 0,
        @SerializedName("limit")
        val limit: Int? = 0,
        @SerializedName("offset")
        val offset: Int? = 0,
        @SerializedName("results")
        val results: List<CharacterDataModel?>? = listOf(),
        @SerializedName("total")
        val total: Int? = 0
    )
}
