package me.kariot.composenewsapp.domain.repository

import com.prof.rssparser.Article
import com.prof.rssparser.Parser
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import me.kariot.composenewsapp.data.NewsSource
import me.kariot.composenewsapp.utils.Resource
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val parser: Parser
) : NewsRepository {
    override suspend fun getLatestNews(source: NewsSource) = flow<Resource<List<Article>>> {
        emit(Resource.Loading())
        val url = source.newsUrl
        try {
            val channel = parser.getChannel(url)
            emit(Resource.Success(channel.articles))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(Resource.Error("Could not load articles"))
        }
    }
}