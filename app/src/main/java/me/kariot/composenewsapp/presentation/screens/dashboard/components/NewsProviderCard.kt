package me.kariot.composenewsapp.presentation.screens.dashboard.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import me.kariot.composenewsapp.data.NewsSource
import me.kariot.composenewsapp.data.source.MalayalamDataSources

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun NewsProviderCard(item: NewsSource, onClick: (NewsSource) -> Unit) {
    Card(
        modifier = Modifier
            .padding(6.dp)
            .heightIn(min = 200.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
        onClick = { onClick(item) }
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            val density = LocalDensity.current.density
            Image(
                painter = rememberAsyncImagePainter(model = item.providerLogo),
                contentDescription = item.providerName,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
            )
            var padding by remember {
                mutableStateOf(6.dp)
            }
            Text(
                text = item.providerName,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 6.dp, end = 6.dp, top = 6.dp, bottom = padding),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium,
                onTextLayout = {
                    val lineCount = it.lineCount
                    val height = (it.size.height / density).dp
                    padding = if (lineCount > 1) 6.dp else height
                }
            )
        }
    }
}

@Preview
@Composable
fun NewsProviderCardPreview() {
    NewsProviderCard(
        item = NewsSource(
            MalayalamDataSources.malayalamDataSource.first().providerName,
            MalayalamDataSources.malayalamDataSource.first().providerLogo,
            MalayalamDataSources.malayalamDataSource.first().newsUrl
        )
    ) {}
}