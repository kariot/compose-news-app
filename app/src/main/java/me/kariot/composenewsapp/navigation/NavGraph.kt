package me.kariot.composenewsapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import me.kariot.composenewsapp.presentation.screens.dashboard.DashboardScreen
import me.kariot.composenewsapp.presentation.screens.languageSelection.LanguagePickerScreen
import me.kariot.composenewsapp.presentation.screens.listNews.NewsListScreen

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
        composable(
            Screens.NewsParentScreen.route + "/{selectedIndex}",
            arguments = listOf(navArgument("selectedIndex") {
                type = NavType.IntType
            }),
            content = { entry ->
                NewsListScreen(
                    entry.arguments?.getInt("selectedIndex") ?: 0,
                    navController = navController
                )
            }
        )

    }
}