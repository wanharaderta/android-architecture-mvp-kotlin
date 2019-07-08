package com.maro.baseproject.ui.page.history

import com.maro.baseproject.data.local.ProductPromo

/**
 * Created by Wanhar on 22/06/19.
 * Email : Wanhardaengmaro@gmail.com
 */
interface HistoryContract {
    interface View{
        fun showDialog()
        fun hideDialog()
        fun showListData(productPromo: MutableList<ProductPromo>)
    }
    interface Presenter{
        fun getListData()
    }
}