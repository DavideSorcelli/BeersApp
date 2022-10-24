package it.reply.beersapp.framework.service.api

import it.reply.beersapp.framework.service.model.GetBeersResponseItem
import retrofit2.http.GET

interface BeerApi {

    @GET("beers")
    suspend fun getBeers(): List<GetBeersResponseItem>

}