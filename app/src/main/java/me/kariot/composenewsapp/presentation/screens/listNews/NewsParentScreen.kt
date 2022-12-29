package me.kariot.composenewsapp.presentation.screens.listNews

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import me.kariot.composenewsapp.presentation.screens.common.AppToolbar
import me.kariot.composenewsapp.utils.SharedPref

@Composable
fun NewsParentScreen(selectedIndex: Int, navController: NavController) {

    val selectedlang = SharedPref.getLanguage()
    Scaffold(topBar = { AppToolbar(title = "Latest News") }) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            Text(text = selectedIndex.toString() + "\n" + selectedlang)
        }
    }


}