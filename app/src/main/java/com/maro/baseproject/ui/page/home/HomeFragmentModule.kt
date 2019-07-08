package com.maro.baseproject.ui.page.home

import dagger.Binds
import dagger.Module


/**
 * Created by Wanhar on 27/06/19.
 * Email : Wanhardaengmaro@gmail.com
 */

@Module
abstract class HomeFragmentModule {

    @Binds
    abstract fun bindView(homeFragment: HomeFragment): HomeContract.View

    @Binds
    abstract fun bindPresenter(presenter: HomePresenter): HomeContract.Presenter
}
