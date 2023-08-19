package me.kariot.composenewsapp.presentation.screens.common

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Composable
fun AppToolbar(title: String) {
    TopAppBar(title = { Text(title) })
}

@Composable
fun NavController.AppToolbar(title: String) {
    TopAppBar(title = { Text(title) },
        navigationIcon = if (previousBackStackEntry != null) {
            {
                IconButton(onClick = { navigateUp() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        } else {
            null
        })
}