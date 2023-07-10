package me.kariot.composenewsapp.navigation

sealed class Screens(val route : String){
    object LanguageScreen : Screens(route = "languageScreen")
    object DashScreen : Screens(route = "dashboardScreen")
    object NewsParentScreen : Screens(route = "newsParentScreen")
    object NewsDetailsScreen : Screens(route = "newsDetailsScreen")

    fun <T> withArgs(vararg args: T): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
