package com.maro.baseproject.ui.page.home


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.dgmaro.jantungku.ui.base.BaseFragment
import com.maro.baseproject.R
import com.maro.baseproject.data.local.ProductPromo
import com.maro.baseproject.data.remote.ProductResponse
import com.maro.baseproject.ui.page.home.detail.DetailActivity
import kotlinx.android.synthetic.main.fragment_home.*

import javax.inject.Inject

class HomeFragment : BaseFragment(), HomeContract.View,HomeAdapter.OnItemClickListener {


    @Inject
    lateinit var presenter: HomeContract.Presenter

    var listData: ProductResponse? = null

    lateinit var listProductAdapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAdapterCategories()
        presenter.getListData()
    }


    val listCategoriesAdapter: HomeAdapter by lazy{
        HomeAdapter(2,homeListener = (object : HomeAdapter.OnItemClickListener{
            @SuppressLint("ShowToast")
            override fun onItemCategoriesClick(name: String?) {
                Toast.makeText(context,"Categori $name",Toast.LENGTH_LONG)
            }

            override fun onItemProductClick(product: ProductPromo?) {}

        }),list = listData)
    }


    override fun showListData(response: ProductResponse) {
        listData = response

        setAdapterProduct()
        listCategoriesAdapter.notifyDataSetChanged()
        listProductAdapter.notifyDataSetChanged()
    }


    fun setAdapterCategories() {
        with(rvCatergory){
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(
                context,
                androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL,
                false
            )
            adapter = listCategoriesAdapter
        }
    }

    fun setAdapterProduct() {
        with(rvProduct){
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context)
            listProductAdapter = listData?.let { HomeAdapter(2, this@HomeFragment, it) }!!
            adapter = listProductAdapter
        }
    }

    @SuppressLint("ShowToast")
    override fun onItemCategoriesClick(name: String?) {
        Toast.makeText(context,"Categori $name",Toast.LENGTH_LONG)
    }

    override fun onItemProductClick(product: ProductPromo?) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra("product",product)
        startActivity(intent)

    }

    override fun showErrorMessage(localizedMessage: String?) {

    }


    companion object {
        val TAG: String = "HomeFragment"

        fun newInstance(): HomeFragment = HomeFragment()
    }

}
