package br.leeloo.shopchallenge.features.ride.rideestimate.domain.model

internal data class Ride(
    val id: Int,
    val date: String,
    val origin: String,
    val destination: String,
    val distance: Double,
    val duration: Int,
    val driver: Driver,
    val value: Double
)