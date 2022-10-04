package me.kariot.composenewsapp.navigation

sealed class Screens(val route : String){
    object LanguageScreen : Screens(route = "languageScreen")
    object DashScreen : Screens(route = "dashboardScreen")
}
