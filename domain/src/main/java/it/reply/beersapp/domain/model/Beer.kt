package it.reply.beersapp.domain.model

import kotlin.random.Random

data class Beer(
    val id: Long,
    val name: String,
    val description: String
) {
    companion object {
        fun mock(): Beer {
            return Beer(
                id = Random.nextLong(),
                name = "Peroni",
                description = "Peroni beer was born in 1846 in Vigevano by Francesco Peroni"
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
