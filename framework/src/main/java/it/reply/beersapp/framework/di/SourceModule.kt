@file:Suppress("unused")

package it.reply.beersapp.framework.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import it.reply.beersapp.data.datasource.local.BeerLocalSource
import it.reply.beersapp.data.datasource.remote.BeerRemoteSource
import it.reply.beersapp.framework.datasource.local.BeerLocalSourceImpl
import it.reply.beersapp.framework.datasource.remote.BeerRemoteSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class SourceModule {

    @Binds
    @Singleton
    abstract fun bindsBeerLocalSource(
        beerLocalSource: BeerLocalSourceImpl
    ): BeerLocalSource

    @Binds
    @Singleton
    abstract fun bindsBeerRemoteSource(
        beerLocalSource: BeerRemoteSourceImpl
    ): BeerRemoteSource

}