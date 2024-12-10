package br.leeloo.shopchallenge.core.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

interface RideNavigation {
    fun navigateToRide(navGraphBuilder: NavGraphBuilder, navController: NavHostController)
}