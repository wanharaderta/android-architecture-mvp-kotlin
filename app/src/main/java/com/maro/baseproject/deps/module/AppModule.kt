package com.maro.baseproject.deps.module

import android.content.Context
import androidx.multidex.MultiDexApplication
import com.maro.baseproject.api.RealmService
import com.maro.baseproject.data.db.LocalPref
import dagger.Module
import dagger.Provides
import io.realm.Realm



/**
 * Created by Wanhar on 22/06/19.
 * Email : Wanhardaengmaro@gmail.com
 */

@Module
class AppModule {

    @Provides
    fun provideContext(app: MultiDexApplication): Context = app.applicationContext

    @Provides
    fun providePreferences(context: Context):LocalPref = LocalPref(context)

    @Provides
    fun provideRealm(): Realm {
        return Realm.getDefaultInstance()
    }

    @Provides
    fun provideRealmService(realm: Realm): RealmService {
        return RealmService(realm)
    }

}