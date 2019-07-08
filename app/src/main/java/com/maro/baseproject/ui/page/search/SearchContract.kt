package com.maro.baseproject.ui.page.search

import com.maro.baseproject.data.local.ProductPromo

/**
 * Created by Wanhar on 22/06/19.
 * Email : Wanhardaengmaro@gmail.com
 */
interface SearchContract {
    interface View{
        fun showDialog()
        fun hideDialog()
        fun showListData(response: List<ProductPromo?>?);
        fun showErrorMessage(localizedMessage: String?)
    }
    interface Presenter{
        fun getListData()
    }
}