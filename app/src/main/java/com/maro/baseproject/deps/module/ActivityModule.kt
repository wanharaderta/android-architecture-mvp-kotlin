package com.maro.baseproject.deps.module

import com.maro.baseproject.deps.ActivityScope
import com.maro.baseproject.ui.page.main.MainActivity
import com.maro.baseproject.ui.page.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Wanhar on 22/06/19.
 * Email : Wanhardaengmaro@gmail.com
 */


@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules =[MainActivityModule::class])
    internal abstract fun mainActivity(): MainActivity

}