package it.reply.beersapp.data.repository

import io.mockk.*
import it.reply.beersapp.data.datasource.local.BeerLocalSource
import it.reply.beersapp.data.datasource.remote.BeerRemoteSource
import it.reply.beersapp.domain.model.Beer
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Test

internal class BeerRepositoryImplTest {

    private val localDataSource: BeerLocalSource = mockk()
    private val remoteDataSource: BeerRemoteSource = mockk()

    private val beerRepository = BeerRepositoryImpl(localDataSource, remoteDataSource)

    @After
    fun tearDown() {
        unmockkAll()
        clearAllMocks()
    }


    @Test
    fun `when call fetchBeers() get success`() {
        val beers = listOf(
            Beer(
                id = 1,
                name = "testName",
                description = "testDescription",
                imageUrl = "testImageUrl"
            )
        )

        coEvery { localDataSource.save(eq(beers)) } returns Unit
        coEvery { remoteDataSource.getAll() } returns beers

        runTest {
            val result = beerRepository.fetchBeers()

            Assert.assertArrayEquals(result.toTypedArray(), beers.toTypedArray())
        }

        coVerify(exactly = 1) { localDataSource.save(eq(beers)) }
        coVerify(exactly = 1) { remoteDataSource.getAll() }
    }

}