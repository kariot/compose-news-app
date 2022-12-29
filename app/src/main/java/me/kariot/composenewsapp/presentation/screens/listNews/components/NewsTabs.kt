package me.kariot.composenewsapp.presentation.screens.listNews.components

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
import me.kariot.composenewsapp.data.NewsSource
import me.kariot.composenewsapp.presentation.screens.dashboard.getNewsSource

@OptIn(ExperimentalPagerApi::class)
@Composable
fun NewsTabs(newsSource: List<NewsSource>, pagerState: PagerState) {
    val scope = rememberCoroutineScope()
    ScrollableTabRow(
        selectedTabIndex = pagerState.currentPage,
        contentColor = MaterialTheme.colors.primary,
        backgroundColor = Color.Transparent,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(Modifier.pagerTabIndicatorOffset(pagerState, tabPositions))
        }
    ) {
        newsSource.forEachIndexed { index, tab ->
            Tab(
                text = { Text(text = newsSource[index].providerName) },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                })
        }
    }
}