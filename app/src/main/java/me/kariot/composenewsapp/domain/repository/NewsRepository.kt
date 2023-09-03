package me.kariot.composenewsapp.domain.repository

import com.prof18.rssparser.model.RssItem
import kotlinx.coroutines.flow.Flow
import me.kariot.composenewsapp.data.NewsSource
import me.kariot.composenewsapp.utils.Resource

interface NewsRepository {
    suspend fun getLatestNews(source: NewsSource): Flow<Resource<List<RssItem>>>
}