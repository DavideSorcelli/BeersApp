@file:Suppress("unused")

package it.reply.beersapp.framework.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import it.reply.beersapp.framework.database.BeersDatabase
import it.reply.beersapp.framework.database.dao.BeerDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext appContext: Context
    ): BeersDatabase {
        return Room.databaseBuilder(appContext, BeersDatabase::class.java, "beers_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideBeerDao(
        database: BeersDatabase
    ): BeerDao {
        return database.beerDao()
    }

}