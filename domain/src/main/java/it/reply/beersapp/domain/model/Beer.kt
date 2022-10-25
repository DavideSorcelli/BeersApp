package it.reply.beersapp.domain.model

import kotlin.random.Random

data class Beer(
    val id: Long,
    val name: String,
    val description: String,
    val imageUrl: String?
) {
    companion object {
        fun mock(): Beer {
            return Beer(
                id = Random.nextLong(),
                name = "Peroni",
                description = "Peroni beer was born in 1846 in Vigevano by Francesco Peroni",
                imageUrl = "https://images.punkapi.com/v2/keg.png"
            )
        }
        fun mockList(): List<Beer> {
            return buildList {
                repeat(10) {
                    add(mock())
                }
            }
        }
    }
}
