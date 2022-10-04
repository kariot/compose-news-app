package me.kariot.composenewsapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import me.kariot.composenewsapp.presentation.screens.dashboard.DashboardScreen
import me.kariot.composenewsapp.presentation.screens.languageSelection.LanguagePickerScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.LanguageScreen.route) {
        composable(
            Screens.LanguageScreen.route,
            content = {
                LanguagePickerScreen(navController)
            }
        )

        composable(
            Screens.DashScreen.route,
            content = {
                DashboardScreen(navController)
            }
        )
    }
}