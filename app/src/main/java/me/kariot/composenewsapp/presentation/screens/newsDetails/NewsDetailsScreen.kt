package me.kariot.composenewsapp.presentation.screens.newsDetails

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.prof.rssparser.Article

@OptIn(ExperimentalPagerApi::class)
@Composable
fun NewsDetailsScreen(articles: List<Article>, _selectedIndex: Int) {
    var selectedIndex by remember {
        mutableStateOf(_selectedIndex)
    }
    val pagerState = rememberPagerState(initialPage = selectedIndex)
    LaunchedEffect(pagerState) {
        // Collect from the a snapshotFlow reading the currentPage
        snapshotFlow { pagerState.currentPage }.collect { page ->
            selectedIndex = page
        }
    }
    HorizontalPager(state = pagerState, count = articles.size) {
        Text(text = articles[selectedIndex].description ?: "")
    }
}