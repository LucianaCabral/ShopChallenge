package br.leeloo.shopchallenge.features.ride.rideestimate.domain.repository

import br.leeloo.shopchallenge.features.ride.rideestimate.domain.model.RideEstimate
import kotlinx.coroutines.flow.Flow

internal interface RideEstimateRepository {
    fun getEstimateRide(
        customerId: String,
        origin: String,
        destination: String
    ): Flow<RideEstimate>
}
