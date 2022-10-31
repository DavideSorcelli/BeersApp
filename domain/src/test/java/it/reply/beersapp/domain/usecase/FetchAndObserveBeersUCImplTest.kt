package it.reply.beersapp.domain.usecase

import io.mockk.*
import it.reply.beersapp.domain.model.Beer
import it.reply.beersapp.domain.repository.BeerRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Test

internal class FetchAndObserveBeersUCImplTest {

    private val dispatcher = UnconfinedTestDispatcher()
    private val beerRepository: BeerRepository = mockk()
    private val beersUC = FetchAndObserveBeersUCImpl(beerRepository, dispatcher)

    @After
    fun tearDown() {
        unmockkAll()
        clearAllMocks()
    }

    @Test
    fun `when invoke use case i get a flow with beers`() {

        val beers = listOf(Beer(
            id = 1,
            name = "testName",
            description = "testDescription",
            imageUrl = "testImageUrl"
        ))
        val beersFlow = MutableStateFlow(beers)

        every { beerRepository.observeBeers() } returns beersFlow
        coEvery { beerRepository.fetchBeers() } returns beers

        runTest(dispatcher) {
            val first = beersUC().first()

            Assert.assertArrayEquals(first.toTypedArray(), beers.toTypedArray())
        }

        verify(exactly = 1) { beerRepository.observeBeers() }
        coVerify(exactly = 1) { beerRepository.fetchBeers() }
    }

}