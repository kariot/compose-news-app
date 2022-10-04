package me.kariot.composenewsapp.presentation.screens.languageSelection

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.kariot.composenewsapp.data.models.languageSelection.Languages

@Composable
fun LanguageCard(
    index: Int,
    language: Languages,
    onItemClick: (Int) -> Unit,
    isSelected: Boolean
) {
    val cardStroke = BorderStroke(
        3.dp, if (isSelected) Color.Green else Color.Transparent
    )

    Card(
        shape = RoundedCornerShape(12.dp),
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 4.dp,
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                onItemClick.invoke(index)
            },
        border = cardStroke
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            LanguageThumbnail(language.firstLetter, language.ItemColor)
            Spacer(modifier = Modifier.size(12.dp))
            LanguageTitle(language.title)
        }
    }
}

@Preview
@Composable
fun LanguageCardPreview() {
    LanguageCard(0, Languages("E", Color.Magenta, "English"), { _ -> }, false)
}