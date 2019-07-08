package com.maro.baseproject.ui.page.main

import com.maro.baseproject.deps.ActivityScope
import com.maro.baseproject.ui.page.history.HistoryFragment
import com.maro.baseproject.ui.page.history.HistoryFragmentModule
import com.maro.baseproject.ui.page.home.HomeFragment
import com.maro.baseproject.ui.page.home.HomeFragmentModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Wanhar on 22/06/19.
 * Email : Wanhardaengmaro@gmail.com
 */

@Module
abstract class MainActivityModule {

    @ActivityScope
    @Binds
    abstract fun bindView(mainActivity: MainActivity): MainContract.View

    @ActivityScope
    @Binds
    abstract fun bindPresenter(presenter: MainPresenter): MainContract.Presenter

    @ContributesAndroidInjector(modules = [HomeFragmentModule::class])
    abstract fun homeFragmentInjector(): HomeFragment

    @ContributesAndroidInjector(modules = [HistoryFragmentModule::class])
    abstract fun historyFragmentInjector(): HistoryFragment

}