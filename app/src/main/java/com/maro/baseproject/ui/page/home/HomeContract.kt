package com.maro.baseproject.ui.page.home

import com.maro.baseproject.data.remote.ProductResponse

/**
 * Created by Wanhar on 22/06/19.
 * Email : Wanhardaengmaro@gmail.com
 */
interface HomeContract {
    interface View{
        fun showDialog()
        fun hideDialog()
        fun showListData(response: ProductResponse);
        fun showErrorMessage(localizedMessage: String?)
    }
    interface Presenter{
        fun getListData()
    }
}