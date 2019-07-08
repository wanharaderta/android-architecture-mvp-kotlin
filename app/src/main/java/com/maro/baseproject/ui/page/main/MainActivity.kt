package com.maro.baseproject.ui.page.main

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.maro.baseproject.R
import com.maro.baseproject.ui.base.BaseActivity
import com.maro.baseproject.ui.page.history.HistoryFragment
import com.maro.baseproject.ui.page.home.HomeFragment
import com.maro.baseproject.ui.page.search.SearchActivity
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), HasSupportFragmentInjector, MainContract.View {


    @Inject
    lateinit var presenter: MainContract.Presenter

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_main)

        changeFragment(supportFragmentManager,HomeFragment().newInstance(),R.id.frame,HomeFragment.TAG,true)
        navigation.setOnNavigationItemSelectedListener{item ->
            when(item.itemId){
                R.id.navigation_home -> {
                    changeFragment(supportFragmentManager,HomeFragment().newInstance(),R.id.frame,HomeFragment.TAG,true)
                }
                R.id.navigation_news -> {

                }
                R.id.navigation_history -> {
                    changeFragment(supportFragmentManager,HistoryFragment().newInstance(),R.id.frame,HistoryFragment.TAG,false)
                }
                R.id.navigation_profile -> {

                }
            }
            true
        }

        input_search.setOnClickListener {
            val intent = Intent(this,SearchActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()
    }

    override fun showDialog() {

    }

    override fun hideDialog() {

    }

    override fun supportFragmentInjector() = dispatchingAndroidInjector


}
