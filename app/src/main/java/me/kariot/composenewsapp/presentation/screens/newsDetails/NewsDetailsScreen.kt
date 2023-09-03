package me.kariot.composenewsapp.presentation.screens.newsDetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import me.kariot.composenewsapp.presentation.screens.common.AppToolbar
import me.kariot.composenewsapp.presentation.screens.listNews.NewsListViewModel
import me.kariot.composenewsapp.presentation.ui.composables.HtmlText

@OptIn(ExperimentalPagerApi::class)
@Composable
fun NewsDetailsScreen(
    index: Int, navController: NavHostController, viewModel: NewsListViewModel
) {
    val articles = viewModel.newsList.collectAsState().value.data
    var selectedIndex by remember {
        mutableStateOf(index)
    }
    val pagerState = rememberPagerState(initialPage = index)
    LaunchedEffect(pagerState) {
        // Collect from the a snapshotFlow reading the currentPage
        snapshotFlow { pagerState.currentPage }.collect { page ->
            selectedIndex = page
        }
    }
    articles?.get(selectedIndex)?.let { article ->

        Scaffold(topBar = {
            navController.AppToolbar(title = "Article")
        }) {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(it)
                    .padding(horizontal = 12.dp)
            ) {
                AsyncImage(
                    contentScale = ContentScale.Crop,
                    model = article.image,
                    contentDescription = article.description,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(4f / 3)
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(text = article.title ?: "")
                HtmlText(html = article.description ?: "")
            }

        }

    }

}