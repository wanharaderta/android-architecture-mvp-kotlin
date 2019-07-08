package com.maro.baseproject.ui.base

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager


/**
 * Created by Wanhar on 26/06/19.
 * Email : Wanhardaengmaro@gmail.com
 */
open class BaseActivity : AppCompatActivity(){

    fun changeFragment(
        fragmentManager: FragmentManager, fragment: Fragment, frameId: Int,
        tag: String,
        addToBackStack: Boolean
    ) {
        if (addToBackStack) {
            fragmentManager.beginTransaction().replace(frameId, fragment, tag).addToBackStack(null).commit()
        } else {
            fragmentManager.beginTransaction().replace(frameId, fragment, tag).commit()
        }
    }
}