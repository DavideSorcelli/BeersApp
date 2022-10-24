@file:Suppress("unused")

package it.reply.beersapp.framework.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import it.reply.beersapp.domain.usecase.FetchAndObserveBeersUC
import it.reply.beersapp.domain.usecase.FetchAndObserveBeersUCImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    @Singleton
    abstract fun bindsFetchAndObserveBeersUC(
        fetchAndObserveBeersUC: FetchAndObserveBeersUCImpl
    ): FetchAndObserveBeersUC

}
