package com.maro.baseproject.ui.page.search

import com.maro.baseproject.api.ApiService
import com.maro.baseproject.data.remote.ProductResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Wanhar on 22/06/19.
 * Email : Wanhardaengmaro@gmail.com
 */
class SearchPresenter @Inject constructor(
    val view: SearchContract.View,
    val api: ApiService
) : SearchContract.Presenter {

    private val subscriptions = CompositeDisposable()

    override fun getListData() {
        view.showDialog()
        val subscribe = api.getListData().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response: List<ProductResponse> ->
                view.showListData(response[0].data?.productPromo)
                view.hideDialog()
            }, { error ->
                view.hideDialog()
                view.showErrorMessage(error.localizedMessage)
            })
        subscriptions.add(subscribe)
    }


}