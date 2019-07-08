package com.maro.baseproject.ui.page.main

import com.maro.baseproject.data.db.LocalPref
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by Wanhar on 22/06/19.
 * Email : Wanhardaengmaro@gmail.com
 */
class MainPresenter @Inject constructor(
    val view: MainContract.View,
    val localPref:LocalPref
) : MainContract.Presenter {


    override fun test() {
        localPref.setValue(LocalPref.Key.LOGIN,true)
    }

    private val subscriptions = CompositeDisposable()


}