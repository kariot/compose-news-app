package me.kariot.composenewsapp.utils

import android.content.Context
import android.content.SharedPreferences

object SharedPref {
    private lateinit var sharedPref: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    private const val IS_LANG_PICKED = "IS_LANG_PICKED"

    fun init(context: Context) {
        sharedPref = context.getSharedPreferences("LOCAL_PREF", Context.MODE_PRIVATE)
        editor = sharedPref.edit()
    }

    fun isLanguagePicked(): Boolean {
        return sharedPref.getBoolean(IS_LANG_PICKED, false)
    }

    fun setLanguagePicked() {
        editor.putBoolean(IS_LANG_PICKED, true).commit()
    }

}