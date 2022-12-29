package me.kariot.composenewsapp.presentation.screens.common

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable

@Composable
fun AppToolbar(title : String) {
    TopAppBar(title = { Text(title) })
}