package me.kariot.composenewsapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import me.kariot.composenewsapp.utils.SharedPref
@HiltAndroidApp
class NewsApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        SharedPref.init(this)
    }
}