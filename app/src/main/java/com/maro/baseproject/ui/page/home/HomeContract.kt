package com.maro.baseproject.ui.page.home

import com.maro.baseproject.data.remote.ProductResponse
import com.maro.baseproject.ui.base.BaseContract
import com.maro.baseproject.ui.page.main.MainContract

/**
 * Created by Wanhar on 22/06/19.
 * Email : Wanhardaengmaro@gmail.com
 */
interface HomeContract{
    interface View : BaseContract.View{
        fun showListData(response: ProductResponse);
        fun showErrorMessage(localizedMessage: String?)
    }
    interface Presenter : BaseContract.Presenter<MainContract>{
        fun getListData()
    }
}