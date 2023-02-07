package me.kariot.composenewsapp.presentation.screens.listNews

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import me.kariot.composenewsapp.data.NewsSource
import me.kariot.composenewsapp.utils.Resource
import javax.inject.Inject


@HiltViewModel
class NewsListViewModel @Inject constructor() : ViewModel() {
    private val _newsList: MutableStateFlow<Resource<List<String>>> = MutableStateFlow(Resource.Loading())
    val newsList = _newsList.asStateFlow()

    fun getNews(source: NewsSource) {

    }


}