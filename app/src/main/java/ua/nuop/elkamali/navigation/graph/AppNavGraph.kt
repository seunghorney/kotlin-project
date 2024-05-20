package ua.nuop.elkamali.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ua.nuop.elkamali.navigation.destination.ApplicationDestination
import ua.nuop.elkamali.ui.screen.MainScreens


@Composable
fun AppNavGraph(startDestination: String) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {
        composable(ApplicationDestination.MainScreens.route){
            MainScreens()
        }

    }
}