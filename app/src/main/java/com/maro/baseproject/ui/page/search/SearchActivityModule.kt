package com.maro.baseproject.ui.page.search

import com.maro.baseproject.deps.ActivityScope
import dagger.Binds
import dagger.Module

/**
 * Created by Wanhar on 28/06/19.
 * Email : Wanhardaengmaro@gmail.com
 */
@Module
abstract class SearchActivityModule{

    @ActivityScope
    @Binds
    abstract fun bindView(searchActivity: SearchActivity): SearchContract.View

    @ActivityScope
    @Binds
    abstract fun bindPresenter(presenter: SearchPresenter): SearchContract.Presenter


}