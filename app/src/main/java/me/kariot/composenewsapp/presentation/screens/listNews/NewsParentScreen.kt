package me.kariot.composenewsapp.presentation.screens.listNews

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import me.kariot.composenewsapp.presentation.screens.common.AppToolbar
import me.kariot.composenewsapp.presentation.screens.dashboard.getNewsSource
import me.kariot.composenewsapp.presentation.screens.listNews.components.NewsList
import me.kariot.composenewsapp.presentation.screens.listNews.components.NewsTabs

@OptIn(ExperimentalPagerApi::class)
@Composable
fun NewsParentScreen(selectedIndex: Int, navController: NavController) {
    val pagerState = rememberPagerState(selectedIndex)
    val newsSource = getNewsSource()
    val scope = rememberCoroutineScope()
    Scaffold(topBar = { AppToolbar(title = "Latest News") }) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            NewsTabs(newsSource = newsSource, pagerState = pagerState)
            HorizontalPager(count = newsSource.count(), state = pagerState) { page ->
                NewsList(newsSource[page])
            }
        }
    }


}