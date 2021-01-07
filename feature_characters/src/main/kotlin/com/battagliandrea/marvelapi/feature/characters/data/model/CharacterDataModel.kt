package com.battagliandrea.marvelapi.feature.characters.data.model

import com.battagliandrea.marvelapi.feature.characters.domain.model.CharacterDomainModel
import com.google.gson.annotations.SerializedName

internal data class CharacterDataModel(
    @SerializedName("comics")
    val comics: CharacterComicsDataModel? = CharacterComicsDataModel(),
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("events")
    val events: CharacterEventsDataModel? = CharacterEventsDataModel(),
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("modified")
    val modified: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("resourceURI")
    val resourceURI: String? = "",
    @SerializedName("series")
    val series: CharacterSeriesDataModel? = CharacterSeriesDataModel(),
    @SerializedName("stories")
    val stories: CharacterStoriesDataModel? = CharacterStoriesDataModel(),
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail? = Thumbnail(),
    @SerializedName("urls")
    val urls: List<Url?>? = listOf()
) {

    internal data class Thumbnail(
        @SerializedName("extension")
        val extension: String? = "",
        @SerializedName("path")
        val path: String? = ""
    )

    internal data class Url(
        @SerializedName("type")
        val type: String? = "",
        @SerializedName("url")
        val url: String? = ""
    )
}

internal fun List<CharacterDataModel?>.toDomainModels(): List<CharacterDomainModel> =
        this.filterNotNull()
                .map { it.toDomainModel() }

internal fun CharacterDataModel.toDomainModel(): CharacterDomainModel =
    CharacterDomainModel(
            id = this.id ?: 0,
            name = this.name.orEmpty(),
            imageUrl = "${this.thumbnail?.path.orEmpty()}.${this.thumbnail?.extension.orEmpty()}"

    )
