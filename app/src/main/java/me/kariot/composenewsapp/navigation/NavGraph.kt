package me.kariot.composenewsapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import me.kariot.composenewsapp.presentation.screens.dashboard.DashboardScreen
import me.kariot.composenewsapp.presentation.screens.languageSelection.LanguagePickerScreen
import me.kariot.composenewsapp.presentation.screens.listNews.NewsListScreen
import me.kariot.composenewsapp.presentation.screens.listNews.NewsListViewModel
import me.kariot.composenewsapp.presentation.screens.newsDetails.NewsDetailsScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    val viewModel: NewsListViewModel = hiltViewModel()
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
                    navController = navController,
                    viewModel
                )
            }
        )
        composable(
            Screens.NewsDetailsScreen.route + "/{selectedIndex}",
            arguments = listOf(navArgument("selectedIndex") {
                type = NavType.IntType
            }),
            content = { entry ->
                NewsDetailsScreen(
                    entry.arguments?.getInt("selectedIndex") ?: 0,
                    navController,
                    viewModel
                )
            }
        )

    }
}