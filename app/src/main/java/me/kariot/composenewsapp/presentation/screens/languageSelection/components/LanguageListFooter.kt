package me.kariot.composenewsapp.presentation.screens.languageSelection

import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LanguageListFooter(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .defaultMinSize(
                minHeight = 50.dp
            ),
        shape = RoundedCornerShape(30.dp),
    ) {
        Text(text = "Continue", fontWeight = FontWeight.Medium)
    }
}

@Preview
@Composable
fun LanguageListFooterPreview() {
    LanguageListFooter {

    }
}