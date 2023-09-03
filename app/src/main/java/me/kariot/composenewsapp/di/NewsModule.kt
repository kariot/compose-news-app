package me.kariot.composenewsapp.di

import com.prof18.rssparser.RssParser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.kariot.composenewsapp.domain.repository.NewsRepository
import me.kariot.composenewsapp.domain.repository.NewsRepositoryImpl
import org.xml.sax.Parser
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NewsModule {
    @Provides
    @Singleton
    fun provideNewsRepository(parser: RssParser): NewsRepository = NewsRepositoryImpl(parser)
}