package me.kariot.composenewsapp.domain.repository

import android.util.Log
import com.prof18.rssparser.RssParser
import com.prof18.rssparser.model.RssItem
import kotlinx.coroutines.flow.flow
import me.kariot.composenewsapp.data.NewsSource
import me.kariot.composenewsapp.utils.Resource
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val parser: RssParser
) : NewsRepository {
    override suspend fun getLatestNews(source: NewsSource) = flow<Resource<List<RssItem>>> {
        emit(Resource.Loading())
        val url = source.newsUrl
        try {
            val channel = parser.getRssChannel(url)
            Log.d("<>Result", channel.items.toString())
            emit(Resource.Success(channel.items))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(Resource.Error("Could not load articles"))
        }
    }
}