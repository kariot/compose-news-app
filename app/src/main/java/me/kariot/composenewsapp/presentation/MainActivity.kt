package me.kariot.composenewsapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import me.kariot.composenewsapp.presentation.screens.dashboard.DashboardScreen
import me.kariot.composenewsapp.presentation.screens.languageSelection.LanguagePickerScreen
import me.kariot.composenewsapp.presentation.ui.theme.ComposeNewsAppTheme
import me.kariot.composenewsapp.utils.SharedPref

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNewsAppTheme {
                if (SharedPref.isLanguagePicked()) {
                    DashboardScreen()
                } else {
                    LanguagePickerScreen()
                }
            }
        }
    }
}