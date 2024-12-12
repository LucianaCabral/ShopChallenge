package br.leeloo.shopchallenge.features.ride.rideestimate.domain.model

internal data class RideEstimate(
    val origin: Location,
    val destination: Location,
    val distance: Double,
    val duration: String,
    val options: List<RideOption>,
    val route: Route
)
