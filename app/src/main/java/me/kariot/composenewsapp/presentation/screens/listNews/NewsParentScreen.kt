package me.kariot.composenewsapp.presentation.screens.listNews

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import me.kariot.composenewsapp.presentation.screens.common.AppToolbar
import me.kariot.composenewsapp.presentation.screens.common.ErrorScreen
import me.kariot.composenewsapp.presentation.screens.common.Loader
import me.kariot.composenewsapp.presentation.screens.dashboard.getNewsSource
import me.kariot.composenewsapp.presentation.screens.listNews.components.NewsTabs
import me.kariot.composenewsapp.utils.Resource

@OptIn(ExperimentalPagerApi::class)
@Composable
fun NewsListScreen(
    selectedIndex: Int, navController: NavController, viewModel: NewsListViewModel = hiltViewModel()
) {

    val localNewsSource = getNewsSource()
    val pagerState = rememberPagerState(selectedIndex)
    LaunchedEffect(pagerState) {
        snapshotFlow {
            pagerState.currentPage
        }.collect {
            viewModel.getNews(localNewsSource[it])
        }
    }
    val newsList = viewModel.newsList.collectAsState()

    Scaffold(topBar = { AppToolbar(title = "Latest News") }) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            NewsTabs(newsSource = localNewsSource, pagerState = pagerState)
            HorizontalPager(count = localNewsSource.count(), state = pagerState) { page ->
                when (newsList.value) {
                    is Resource.Error -> {
                        ErrorScreen(newsList.value.message ?: "") {
                            viewModel.getNews(localNewsSource[pagerState.currentPage])
                        }
                    }

                    is Resource.Loading -> {
                        Loader()
                    }

                    is Resource.Success -> {
                        NewsListPager(newsList.value.data ?: emptyList()) {

                        }
                    }
                }

            }
        }
    }


}