package com.maro.baseproject.data.db
import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.maro.baseproject.R

/**
 * Created by Wanhar on 22/06/19.
 * Email : Wanhardaengmaro@gmail.com
 */
class LocalPref(val context: Context){
    private val SETTINGS_NAME = R.string.app_name.toString()
    lateinit var prefs: SharedPreferences

    fun getValue(key:Key, defaultValue: Any): Any {
        return findPreferences(key, defaultValue)
    }

    fun setValue(key:Key, value: Any) {
        savePreference(key, value)
    }

    @SuppressLint("CommitPrefEdits")
    fun clear(){
        prefs.edit().clear()
    }

    @Suppress("UNCHECKED_CAST")
    private fun findPreferences(key: Key, defaultValue: Any): Any {
        prefs = context.getSharedPreferences(SETTINGS_NAME, Context.MODE_PRIVATE)
        with(prefs)
        {
            val result: Any = when (defaultValue) {
                is Boolean -> getBoolean(key.name, defaultValue)
                is Int -> getInt(key.name, defaultValue)
                is Long -> getLong(key.name, defaultValue)
                is Float -> getFloat(key.name, defaultValue)
                is String -> getString(key.name, defaultValue)
                else -> throw IllegalArgumentException()
            }!!
            return result
        }
    }

    @SuppressLint("CommitPrefEdits")
    private fun savePreference(key: Key, value: Any) {
        prefs = context.getSharedPreferences(SETTINGS_NAME, Context.MODE_PRIVATE)
        with(prefs.edit())
        {
            when (value) {
                is Boolean -> putBoolean(key.name, value)
                is Int -> putInt(key.name, value)
                is Long -> putLong(key.name, value)
                is Float -> putFloat(key.name, value)
                is String -> putString(key.name, value)
                else -> throw IllegalArgumentException()
            }.apply()
        }

    }

    enum class Key{
        LOGIN
    }

}