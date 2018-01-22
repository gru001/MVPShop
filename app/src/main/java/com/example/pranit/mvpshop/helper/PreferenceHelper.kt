package com.example.pranit.mvpshop.helper

import android.content.Context

class PreferenceHelper(context: Context) {
    private val PREFERECE_HELPER = "shop_pref"
    val preferences = context.getSharedPreferences(PREFERECE_HELPER, Context.MODE_PRIVATE)
    val PREF_KEY_DATA_LOADED = "data_loaded"

    fun isDataLoaded() :Boolean {
        return preferences.getBoolean(PREF_KEY_DATA_LOADED, false)
    }

    fun setDataLoaded(flag: Boolean) {
        val editor = preferences.edit()
        editor.putBoolean(PREF_KEY_DATA_LOADED, flag)
        editor.apply()
    }
}