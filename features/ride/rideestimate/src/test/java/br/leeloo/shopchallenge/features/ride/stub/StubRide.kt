package br.leeloo.shopchallenge.features.ride.stub

import br.leeloo.shopchallenge.features.ride.rideestimate.domain.model.Location
import br.leeloo.shopchallenge.features.ride.rideestimate.domain.model.RideEstimate
import br.leeloo.shopchallenge.features.ride.rideestimate.domain.model.RideOption
import br.leeloo.shopchallenge.features.ride.rideestimate.domain.model.Route
import io.mockk.mockk

internal object StubRide {
    fun getRideEstimated(): RideEstimate {
        return RideEstimate(
            origin = mockk<Location>(),
            destination = mockk<Location>(),
            distance = 0.000,
            duration = "1",
            options = mockk<List<RideOption>>(),
            route = mockk<Route>(),
        )
    }
}
