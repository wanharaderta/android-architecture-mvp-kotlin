package com.maro.baseproject.ui.page.main

import com.maro.baseproject.deps.ActivityScope
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

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
}