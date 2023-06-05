package me.kariot.composenewsapp.presentation.screens.listNews

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.prof.rssparser.Article
import me.kariot.composenewsapp.presentation.screens.common.Loader
import me.kariot.composenewsapp.presentation.screens.listNews.components.NewsItem
import me.kariot.composenewsapp.utils.Resource

@Composable
fun NewsListPager(articles: List<Article>) {
    LazyColumn{
        items(articles) {
            NewsItem(article = it)
        }
    }
}