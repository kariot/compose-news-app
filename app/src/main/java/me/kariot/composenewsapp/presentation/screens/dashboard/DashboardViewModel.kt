package me.kariot.composenewsapp.presentation.screens.dashboard

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import me.kariot.composenewsapp.domain.repository.NewsRepository
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val repo: NewsRepository
) : ViewModel() {
    fun fetchFeed(){

    }
}