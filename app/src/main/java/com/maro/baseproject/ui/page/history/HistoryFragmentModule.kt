package com.maro.baseproject.ui.page.history

import dagger.Binds
import dagger.Module

/**
 * Created by Wanhar on 28/06/19.
 * Email : Wanhardaengmaro@gmail.com
 */
@Module
abstract class HistoryFragmentModule {

    @Binds
    abstract fun bindView(historyFragment: HistoryFragment): HistoryContract.View

    @Binds
    abstract fun bindPresenter(presenter: HistoryPresenter): HistoryContract.Presenter
}