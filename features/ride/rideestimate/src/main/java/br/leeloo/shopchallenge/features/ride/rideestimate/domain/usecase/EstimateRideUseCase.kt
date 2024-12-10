package br.leeloo.shopchallenge.features.ride.rideestimate.domain.usecase

import br.leeloo.shopchallenge.features.ride.rideestimate.domain.model.RideEstimate
import br.leeloo.shopchallenge.features.ride.rideestimate.domain.repository.RideEstimateRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class EstimateRideUseCase @Inject constructor(
    private val repository: RideEstimateRepository
) {
    operator fun invoke(customerId: String, origin: String, destination: String
    ): Flow<RideEstimate> = repository.getEstimateRide(
        customerId = customerId,
        origin = origin,
        destination = destination
    ).apply {
        println("<L> usercase this = ${this}")
        println("<L> usercase = ${repository.getEstimateRide(
            customerId = customerId,
            origin = origin,
            destination = destination 
        )}")
    }
}