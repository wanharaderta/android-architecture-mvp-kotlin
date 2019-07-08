package com.maro.baseproject.deps.module

import com.maro.baseproject.deps.ActivityScope
import com.maro.baseproject.ui.page.login.LoginActivity
import com.maro.baseproject.ui.page.home.detail.DetailActivity
import com.maro.baseproject.ui.page.main.MainActivity
import com.maro.baseproject.ui.page.main.MainActivityModule
import com.maro.baseproject.ui.page.search.SearchActivity
import com.maro.baseproject.ui.page.search.SearchActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Wanhar on 22/06/19.
 * Email : Wanhardaengmaro@gmail.com
 */


@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules =[MainActivityModule::class,AppModule::class, NetworkModule::class])
    abstract fun mainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun detailActivity(): DetailActivity

    @ActivityScope
    @ContributesAndroidInjector(modules =[SearchActivityModule::class,AppModule::class, NetworkModule::class])
    abstract fun searchActivity(): SearchActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun loginActivity(): LoginActivity

}