package com.maro.baseproject.ui.page.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.maro.baseproject.R
import dagger.android.AndroidInjection

class MainActivity : AppCompatActivity(), MainContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_main)

    }

    override fun showDialog() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideDialog() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
