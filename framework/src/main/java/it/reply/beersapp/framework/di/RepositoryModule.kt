@file:Suppress("unused")

package it.reply.beersapp.framework.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import it.reply.beersapp.data.repository.BeerRepositoryImpl
import it.reply.beersapp.domain.repository.BeerRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsBeerRepository(
        beerRepository: BeerRepositoryImpl
    ): BeerRepository

}