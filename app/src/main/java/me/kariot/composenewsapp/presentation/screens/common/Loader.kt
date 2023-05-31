package me.kariot.composenewsapp.presentation.screens.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Loader() {
    Box(modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator(color = Color.Green, modifier = Modifier.align(Alignment.Center))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewLoader() {
    Loader()
}