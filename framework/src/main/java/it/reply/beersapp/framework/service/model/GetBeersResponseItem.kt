package it.reply.beersapp.framework.service.model


import com.squareup.moshi.Json

data class GetBeersResponseItem(
    val id: Long,
    val name: String,
    val description: String,
    @Json(name = "image_url")
    val imageUrl: String?,
    val abv: Double?,
    val ibu: Double?
)