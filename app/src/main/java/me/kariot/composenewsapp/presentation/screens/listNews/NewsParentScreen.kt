package me.kariot.composenewsapp.presentation.screens.listNews

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import me.kariot.composenewsapp.presentation.screens.common.AppToolbar
import me.kariot.composenewsapp.presentation.screens.dashboard.getNewsSource
import me.kariot.composenewsapp.presentation.screens.listNews.components.NewsTabs

@OptIn(ExperimentalPagerApi::class)
@Composable
fun NewsListScreen(
    selectedIndex: Int, navController: NavController, viewModel: NewsListViewModel = hiltViewModel()
) {
    val pagerState = rememberPagerState(selectedIndex)
    val localNewsSource = getNewsSource()
    val scope = rememberCoroutineScope()

    val newsList = viewModel.newsList.collectAsState()

    Scaffold(topBar = { AppToolbar(title = "Latest News") }) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            NewsTabs(newsSource = localNewsSource, pagerState = pagerState)
            HorizontalPager(count = localNewsSource.count(), state = pagerState) { page ->
                viewModel.getNews(localNewsSource[page])
                NewsListPager(newsList.value)
            }
        }
    }


}