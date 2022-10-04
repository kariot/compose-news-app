package me.kariot.composenewsapp.presentation.screens.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DashboardScreen() {
    Scaffold(
        topBar = {
            TopAppBar { /* Top app bar content */ }
        },
        content = { padding ->
            Column(modifier = Modifier.padding(padding)) {

            }
        }
    )
}