package br.leeloo.shopchallenge.features.ride.rideestimate.domain

import app.cash.turbine.test
import br.leeloo.shopchallenge.features.ride.rideestimate.domain.repository.RideEstimateRepository
import br.leeloo.shopchallenge.features.ride.rideestimate.domain.usecase.EstimateRideUseCase
import br.leeloo.shopchallenge.features.ride.stub.StubRide

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals

internal class EstimateRideUseCaseTest {

    private val repository: RideEstimateRepository = mockk(relaxed = true)
    private val subject = EstimateRideUseCase(repository)
    val customerId = "XYZ"
    val origin = "pointA"
    val destination = "pointB"

    @Test
    fun `Invoke should call getEstimateRide and return flow of RideEstimated`() = runBlocking {
        // Given
        val result = StubRide.getRideEstimated()

        every {
            repository.getEstimateRide(
                customerId = customerId,
                origin = origin,
                destination = destination
            )
        } returns flowOf(result)

        // When
        val estimateRideResult = subject.invoke(
            customerId = customerId,
            origin = origin,
            destination = destination
        )

        // Then
        estimateRideResult.test {
            assertEquals(result, awaitItem(), "O item retornado pelo fluxo não é o esperado.")
            cancelAndConsumeRemainingEvents()
        }
        verify {
            repository.getEstimateRide(
                customerId = customerId,
                origin = origin,
                destination = destination
            )
        }
    }

    @Test
    fun `Ride estimate Should return exception when invoked`() = runBlocking {
        // Given
        val cause = Throwable()

        every {
            repository.getEstimateRide(
                customerId = customerId,
                origin = origin,
                destination = destination
            )
        } returns flow { throw cause }

        // When
        val result = subject(
            customerId = customerId,
            origin = origin,
            destination = destination
        )

        // Then
        result.test {
            assertEquals(
                cause,
                awaitError(),
                "A exceção retornada pelo fluxo não corresponde ào esperada."
            )
        }
        verify {
            repository.getEstimateRide(
                customerId = customerId,
                origin = origin,
                destination = destination
            )
        }
    }

    @Test
    fun `invoke should handle empty flow`() = runBlocking {
        // Given
        every {
            repository.getEstimateRide(
                customerId = customerId,
                origin = origin,
                destination = destination
            )
        } returns flow {}

        // When
        val estimateRideResult = subject(
            customerId = customerId,
            origin = origin,
            destination = destination
        )

        // Then
        estimateRideResult.test {
            awaitComplete()
        }
        verify {
            repository.getEstimateRide(
                customerId = customerId,
                origin = origin,
                destination = destination
            )
        }
    }
}
