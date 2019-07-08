package com.maro.baseproject.ui.page.history

import com.maro.baseproject.api.RealmService
import javax.inject.Inject

/**
 * Created by Wanhar on 27/06/19.
 * Email : Wanhardaengmaro@gmail.com
 */

class HistoryPresenter @Inject constructor(
    val view: HistoryContract.View,
    val realmService: RealmService
) : HistoryContract.Presenter {

    override fun getListData() {
        view.showListData(realmService.allHistorys)
    }


}