package me.kariot.composenewsapp.presentation.screens.listNews

import androidx.compose.runtime.Composable
import me.kariot.composenewsapp.presentation.screens.common.Loader
import me.kariot.composenewsapp.utils.Resource

@Composable
fun NewsListPager(articles: Resource<List<String>>) {
    when (articles) {
        is Resource.Error -> {

        }
        is Resource.Loading -> Loader()
        is Resource.Success -> {

        }
    }
}