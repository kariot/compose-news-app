package me.kariot.composenewsapp.presentation.screens.common

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import java.lang.reflect.Modifier

@Composable
fun Loader() {
    Box {
        CircularProgressIndicator(color = Color.Green)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewLoader() {
    Loader()
}