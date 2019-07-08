package com.maro.baseproject.ui.page.main

/**
 * Created by Wanhar on 22/06/19.
 * Email : Wanhardaengmaro@gmail.com
 */
interface MainContract {
    interface View{
        fun showDialog()
        fun hideDialog()
    }
    interface Presenter{
        fun test()
    }
}