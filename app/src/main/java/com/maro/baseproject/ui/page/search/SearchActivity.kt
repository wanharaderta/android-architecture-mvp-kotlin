package com.maro.baseproject.ui.page.search

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.recyclerview.widget.LinearLayoutManager
import com.maro.baseproject.R
import com.maro.baseproject.data.local.ProductPromo
import com.maro.baseproject.ui.base.BaseActivity
import com.maro.baseproject.ui.page.home.detail.DetailActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_search.*
import javax.inject.Inject

class SearchActivity : BaseActivity(),SearchContract.View, ProductSearchAdapter.ItemClickListener{


    @Inject
    lateinit var presenter: SearchContract.Presenter

    lateinit var listadapter: ProductSearchAdapter

    var listData: MutableList<ProductPromo>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_search)

        presenter.getListData()


        input_search.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

            }

            override fun afterTextChanged(editable: Editable) {
                if (editable.length > 0 ){
                    listadapter.filter.filter(editable.toString())
                }
            }
        })
    }


    fun setAdapter(){
        with(rvProduct){
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            listadapter = ProductSearchAdapter(context,listData,this@SearchActivity)
            adapter = listadapter
        }
    }

    override fun showDialog() {

    }

    override fun hideDialog() {

    }

    override fun onItemClicked(product: ProductPromo) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("product",product)
        startActivity(intent)
    }

    override fun showListData(response: List<ProductPromo?>?) {
        listData = response as MutableList<ProductPromo>
        setAdapter()
        listadapter.notifyDataSetChanged()

    }

    override fun showErrorMessage(localizedMessage: String?) {

    }


}
