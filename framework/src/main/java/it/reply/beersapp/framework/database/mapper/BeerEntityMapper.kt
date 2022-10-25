package it.reply.beersapp.framework.database.mapper

import it.reply.beersapp.domain.model.Beer
import it.reply.beersapp.framework.database.entities.BeerEntity

fun BeerEntity.toDomain(): Beer {
    return Beer(
        id = this.id,
        name = this.name,
        description = this.description,
        imageUrl = this.imageUrl
    )
}

fun Beer.toEntity(): BeerEntity {
    return BeerEntity(
        id = this.id,
        name = this.name,
        description = this.description,
        imageUrl = this.imageUrl
    )
}