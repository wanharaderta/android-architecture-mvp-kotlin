package com.maro.baseproject.data.db

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.maro.baseproject.R
import kotlin.reflect.KProperty

/**
 * Created by Wanhar on 22/06/19.
 * Email : Wanhardaengmaro@gmail.com
 */
object LocalPref {
    private val SETTINGS_NAME = R.string.app_name.toString()
    lateinit var prefs: SharedPreferences
    private lateinit var sSharedPrefs: LocalPref

    fun getInstance(context: Context): SharedPreferences{
        prefs = context.getSharedPreferences(SETTINGS_NAME, Context.MODE_PRIVATE)
        return prefs
    }

    fun getValue(key:Key, defaultValue: Any) {
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
    private fun findPreferences(key: Key, defaultValue: Any) {
        with(prefs)
        {
            val result: Any = when (defaultValue) {
                is Boolean -> getBoolean(key.name, defaultValue)
                is Int -> getInt(key.name, defaultValue)
                is Long -> getLong(key.name, defaultValue)
                is Float -> getFloat(key.name, defaultValue)
                is String -> getString(key.name, defaultValue)
                else -> throw IllegalArgumentException()
            }
            return result as Unit
        }
    }

    @SuppressLint("CommitPrefEdits")
    private fun savePreference(key: Key, value: Any) {
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