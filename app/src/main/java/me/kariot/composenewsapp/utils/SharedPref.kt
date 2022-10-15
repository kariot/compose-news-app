package me.kariot.composenewsapp.utils

import android.content.Context
import android.content.SharedPreferences

object SharedPref {
    private lateinit var sharedPref: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    private const val PICKED_LANG = "PICKED_LANG"

    fun init(context: Context) {
        sharedPref = context.getSharedPreferences("LOCAL_PREF", Context.MODE_PRIVATE)
        editor = sharedPref.edit()
    }

    fun isLanguagePicked(): Boolean {
        return sharedPref.getString(PICKED_LANG, "")?.isNotBlank() ?: false
    }

    fun getLanguage(): String {
        return sharedPref.getString(PICKED_LANG, "") ?: ""
    }

    fun setLanguage(lang: String) {
        editor.putString(PICKED_LANG, lang).commit()
    }

}