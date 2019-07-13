package com.maro.baseproject

import android.app.Activity
import android.app.Application
import androidx.multidex.MultiDexApplication
import com.google.firebase.FirebaseApp
import com.maro.baseproject.api.RealmService
import com.maro.baseproject.deps.component.ApplicationComponent
import com.maro.baseproject.deps.component.DaggerApplicationComponent
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import io.realm.Realm
import io.realm.RealmConfiguration
import javax.inject.Inject

/**
 * Created by Wanhar on 22/06/19.
 * Email : Wanhardaengmaro@gmail.com
 */
class BaseApp : MultiDexApplication(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        RealmService.initDatabase(this)
        FirebaseApp.initializeApp(this)

        DaggerApplicationComponent.builder()
            .application(this)
            .build()
            .inject(this)

    }

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector

}