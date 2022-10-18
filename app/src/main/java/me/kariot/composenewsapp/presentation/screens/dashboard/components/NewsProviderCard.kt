package me.kariot.composenewsapp.presentation.screens.dashboard.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import me.kariot.composenewsapp.data.NewsSource

@Composable
fun NewsProviderCard(item: NewsSource) {
    Card(modifier = Modifier.padding(6.dp), shape = MaterialTheme.shapes.large, elevation = 4.dp) {
        Column(modifier = Modifier.padding(12.dp)) {
            Image(
                painter = rememberAsyncImagePainter(model = item.providerLogo),
                contentDescription = item.providerName,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
            )
            Text(
                text = item.providerName,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Preview
@Composable
fun NewsProviderCardPreview() {
    NewsProviderCard(
        item = NewsSource(
            "Twenty Four",
            "https://www.twentyfournews.com/wp-content/themes/nextline_v3/images/logo-new.png",
            "https://www.twentyfournews.com/feed"
        )
    )
}