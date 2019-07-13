package com.dgmaro.jantungku.ui.base

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection

/**
 * Created by Wanhar on 13/07/19.
 * Email : Wanhardaengmaro@gmail.com
 */
open class BaseFragment : Fragment() {

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }
}