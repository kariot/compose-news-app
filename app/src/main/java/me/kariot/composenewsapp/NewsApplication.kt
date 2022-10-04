package me.kariot.composenewsapp

import android.app.Application
import me.kariot.composenewsapp.utils.SharedPref

class NewsApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        SharedPref.init(this)
    }
}