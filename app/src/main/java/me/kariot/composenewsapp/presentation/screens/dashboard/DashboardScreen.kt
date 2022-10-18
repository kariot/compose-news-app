package me.kariot.composenewsapp.presentation.screens.dashboard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import me.kariot.composenewsapp.data.NewsSource
import me.kariot.composenewsapp.data.source.EnglishDataSources
import me.kariot.composenewsapp.presentation.screens.dashboard.components.NewsProviderCard
import me.kariot.composenewsapp.utils.SharedPref
import me.kariot.quicknews.api.HindiDataSources
import me.kariot.quicknews.api.KannadaDataSources
import me.kariot.composenewsapp.data.source.MalayalamDataSources
import me.kariot.quicknews.api.TamilDataSources

@Composable
fun DashboardScreen(navController: NavController) {
    val newsProviders = getNewsSource()
    Scaffold(
        topBar = {
            TopAppBar {
                Text(text = "Dashboard")
            }
        },
        content = { padding ->
            Box(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
            ) {
                LazyVerticalGrid(columns = GridCells.Fixed(3)) {
                    items(newsProviders) { item ->
                        NewsProviderCard(item)
                    }
                }
            }
        }
    )
}

fun getNewsSource(): List<NewsSource> {
    return when (SharedPref.getLanguage()) {
        "en" -> {
            EnglishDataSources.englishDataSource
        }
        "ml" -> {
            MalayalamDataSources.malayalamDataSource
        }
        "tl" -> {
            TamilDataSources.tamilDataSource
        }
        "kn" -> {
            KannadaDataSources.kannadaDataSource
        }
        "hn" -> {
            HindiDataSources.hindiDataSource
        }
        else -> {
            throw java.lang.IllegalStateException("Unknown language")
        }
    }
}
