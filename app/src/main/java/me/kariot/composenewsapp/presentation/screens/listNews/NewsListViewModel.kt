package me.kariot.composenewsapp.presentation.screens.listNews

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prof18.rssparser.model.RssItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import me.kariot.composenewsapp.data.NewsSource
import me.kariot.composenewsapp.domain.repository.NewsRepository
import me.kariot.composenewsapp.utils.Resource
import javax.inject.Inject


@HiltViewModel
class NewsListViewModel @Inject constructor(
    private val repository: NewsRepository
) : ViewModel() {
    private val _newsList: MutableStateFlow<Resource<List<RssItem>>> =
        MutableStateFlow(Resource.Loading())
    val newsList = _newsList.asStateFlow()

    fun getNews(source: NewsSource) {
        viewModelScope.launch {
            repository.getLatestNews(source).collect {
                _newsList.value = it
            }
        }
    }


}