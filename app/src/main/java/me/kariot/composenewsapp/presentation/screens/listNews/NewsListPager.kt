package me.kariot.composenewsapp.presentation.screens.listNews

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.prof18.rssparser.model.RssItem
import me.kariot.composenewsapp.presentation.screens.listNews.components.NewsItem

@Composable
fun NewsListPager(articles: List<RssItem>, onClickItem: (RssItem) -> Unit) {
    LazyColumn {
        items(articles) {
            NewsItem(article = it,onClickItem)
        }
    }
}