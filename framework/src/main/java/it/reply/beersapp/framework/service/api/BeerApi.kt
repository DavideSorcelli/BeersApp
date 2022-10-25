package it.reply.beersapp.framework.service.api

import it.reply.beersapp.framework.service.model.GetBeersResponseItem
import retrofit2.http.GET
import retrofit2.http.Query

private const val PARAM_PAGE = "page"
private const val PARAM_PER_PAGE = "per_page"

interface BeerApi {

    @GET("beers")
    suspend fun getBeers(
        @Query(PARAM_PAGE) page: Int = 1,
        @Query(PARAM_PER_PAGE) perPage: Int = 50
    ): List<GetBeersResponseItem>

}