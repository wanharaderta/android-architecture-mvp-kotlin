package com.maro.baseproject.ui.page.home


import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager

import com.maro.baseproject.R
import com.maro.baseproject.data.local.ProductPromo
import com.maro.baseproject.data.remote.ProductResponse
import com.maro.baseproject.ui.page.home.detail.DetailActivity
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : Fragment(), HomeContract.View,HomeAdapter.OnItemClickListener {


    @Inject
    lateinit var presenter: HomeContract.Presenter

    lateinit var listCategoriesAdapter: HomeAdapter
    lateinit var listProductAdapter: HomeAdapter

    lateinit var listData: ProductResponse


    var viewRoot: View? = null

    fun newInstance(): HomeFragment {
        return HomeFragment()
    }

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewRoot = inflater.inflate(R.layout.fragment_home, container, false)

        setAdapterCategories()

        presenter.getListData()

        return viewRoot
    }

    override fun showListData(response: ProductResponse) {
        listData = response

        setAdapterProduct()
        listCategoriesAdapter.notifyDataSetChanged()
        listProductAdapter.notifyDataSetChanged()
    }

    fun setAdapterCategories() {
        with(rvCatergory){
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            listCategoriesAdapter = HomeAdapter(1, this@HomeFragment,listData)
            adapter = listCategoriesAdapter
        }
    }

    fun setAdapterProduct() {
        with(rvProduct){
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            listProductAdapter = HomeAdapter(2, this@HomeFragment,listData)
            adapter = listProductAdapter
        }
    }

    @SuppressLint("ShowToast")
    override fun onItemCategoriesClick(name: String?) {
        Toast.makeText(context,"Categori $name",Toast.LENGTH_LONG)


    }

    override fun onItemProductClick(product: ProductPromo?) {
        val intent = Intent(context,DetailActivity::class.java)
        intent.putExtra("product",product)
        startActivity(intent)

    }

    override fun showErrorMessage(localizedMessage: String?) {

    }

    override fun showDialog() {

    }

    override fun hideDialog() {

    }

    companion object {
        val TAG: String = "HomeFragment"
    }

}
