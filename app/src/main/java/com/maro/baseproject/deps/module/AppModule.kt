package com.maro.baseproject.deps.module

import android.content.Context
import android.content.SharedPreferences
import androidx.multidex.MultiDexApplication
import com.maro.baseproject.data.db.LocalPref
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Wanhar on 22/06/19.
 * Email : Wanhardaengmaro@gmail.com
 */

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(app: MultiDexApplication): Context = app.applicationContext

    @Provides
    @Singleton
    fun providePreferences(context: Context): SharedPreferences = LocalPref.getInstance(context)
}