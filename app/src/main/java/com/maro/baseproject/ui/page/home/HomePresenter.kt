package com.maro.baseproject.ui.page.home

import com.maro.baseproject.api.ApiService
import com.maro.baseproject.data.db.LocalPref
import com.maro.baseproject.data.remote.ProductResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Wanhar on 27/06/19.
 * Email : Wanhardaengmaro@gmail.com
 */

class HomePresenter @Inject constructor(
    val view: HomeContract.View,
    val api: ApiService
) : HomeContract.Presenter {

    private val subscriptions = CompositeDisposable()

    override fun getListData() {
        view.showLoading()
        subscriptions.add(api.getListData().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response: List<ProductResponse> ->
                view.showListData(response[0])
                view.hideLoading()
            }, { error ->
                view.hideLoading()
                view.showErrorMessage(error.localizedMessage)
            }))
    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

}