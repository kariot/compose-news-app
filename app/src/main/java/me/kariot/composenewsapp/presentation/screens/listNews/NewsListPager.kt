package me.kariot.composenewsapp.presentation.screens.listNews

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.prof.rssparser.Article
import me.kariot.composenewsapp.presentation.screens.listNews.components.NewsItem

@Composable
fun NewsListPager(articles: List<Article>, onClickItem: (Article) -> Unit) {
    LazyColumn {
        items(articles) {
            NewsItem(article = it,onClickItem)
        }
    }
}