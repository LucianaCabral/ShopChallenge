package br.leeloo.shopchallenge.features.ride.rideestimate.domain.model

internal data class RideOption(
    val id: Int,
    val name: String,
    val description: String,
    val vehicle: String,
    val review: Review?,
    val price: Double
)
