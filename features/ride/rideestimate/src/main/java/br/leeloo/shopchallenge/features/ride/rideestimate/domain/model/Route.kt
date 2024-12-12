package br.leeloo.shopchallenge.features.ride.rideestimate.domain.model

internal data class Route(
    val polyline: String,
    val waypoints: List<Location>
)