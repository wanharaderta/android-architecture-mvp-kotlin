package com.maro.baseproject.ui.base

/**
 * Created by Wanhar on 22/06/19.
 * Email : Wanhardaengmaro@gmail.com
 */
interface BaseContract {
    interface Presenter<in T> {
        fun unsubscribe()
        fun attach(view: T)
    }

    interface View {

    }
}