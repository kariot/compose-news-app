package me.kariot.composenewsapp.presentation.screens.listNews.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.prof.rssparser.Article

@Composable
fun NewsItem(article: Article) {
    Card(
        shape = RoundedCornerShape(8.dp), modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            AsyncImage(
                contentScale = ContentScale.Crop,
                model = article.image,
                contentDescription = article.description,
                modifier = Modifier
                    .fillMaxWidth(0.3f)
                    .clip(RoundedCornerShape(12.dp))
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = article.title ?: "",
                    color = MaterialTheme.colors.primary,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
                Box(modifier = Modifier.height(8.dp))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = article.content ?: "",
                    color = MaterialTheme.colors.primary,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                )
                Box(modifier = Modifier.height(8.dp))
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp),
                    text = article.pubDate?.substringBefore("+") ?: article.pubDate ?: "",
                    color = MaterialTheme.colors.primary,
                    textAlign = TextAlign.End,

                    )
            }
        }
    }
}

@Preview
@Composable
fun NewsItemPreview() {
    val article = Article(
        image = "https://images.news18.com/malayalam/uploads/2022/11/UPI-16683119143x2.jpg?im=Resize,width=509,aspect=fit,type=normal",
        title = "പെരുമഴ, കടലാക്രമണം , വ്യാപകനാശം ; സംസ്ഥാന വ്യാപകമായി ആയിരത്തോളം ദുരിതാശ്വാസ തോളം ദുരിതാശ്വാസ …..",
        content = "പെരുമഴ, കടലാക്രമണം , വ്യാപകനാശം ; സംസ്ഥാന വ്യാപകമായി ആയിരത്തോളം ദുരിതാശ്വാസ തോളം ദുരിതാശ്വാസ …..",
        pubDate = "10-10-2022"
    )
    NewsItem(article = article)
}



