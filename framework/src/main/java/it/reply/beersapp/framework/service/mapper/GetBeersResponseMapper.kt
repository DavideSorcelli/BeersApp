package it.reply.beersapp.framework.service.mapper

import it.reply.beersapp.domain.model.Beer
import it.reply.beersapp.framework.service.model.GetBeersResponseItem

fun GetBeersResponseItem.toDomain(): Beer {
    return Beer(
        id = this.id,
        name = this.name,
        description = this.description
    )
}