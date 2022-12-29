package me.kariot.composenewsapp.presentation.screens.languageSelection.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LanguageThumbnail(firstLetter: String, backgroundColor: Color) {
    Box(
        modifier = Modifier
            .size(70.dp)
            .background(backgroundColor, shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = firstLetter,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color.White
        )
    }
}

@Preview
@Composable
fun LanguageThumbnailPreview() {
    LanguageThumbnail(firstLetter = "E", backgroundColor = Color.Magenta)
}

