package me.kariot.composenewsapp.domain.repository

import com.prof.rssparser.Article
import kotlinx.coroutines.flow.Flow
import me.kariot.composenewsapp.data.NewsSource
import me.kariot.composenewsapp.utils.Resource

interface NewsRepository {
    suspend fun getLatestNews(source: NewsSource): Flow<Resource<List<Article>>>
}