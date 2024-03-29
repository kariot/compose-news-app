package me.kariot.composenewsapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.appat.reachability.setNetworkListenerContent
import dagger.hilt.android.AndroidEntryPoint
import me.kariot.composenewsapp.navigation.Screens
import me.kariot.composenewsapp.navigation.SetupNavGraph
import me.kariot.composenewsapp.presentation.ui.theme.ComposeNewsAppTheme
import me.kariot.composenewsapp.utils.SharedPref
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    lateinit var navHostController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setNetworkListenerContent {
            ComposeNewsAppTheme {
                navHostController = rememberNavController()
                SetupNavGraph(navController = navHostController)

                if (SharedPref.isLanguagePicked()) {
                    navHostController.navigate(Screens.DashScreen.route)
                }
            }
        }
    }
}