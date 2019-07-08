package com.maro.baseproject.ui.page.history

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.maro.baseproject.R
import com.maro.baseproject.data.local.ProductPromo
import com.maro.baseproject.ui.page.home.detail.DetailActivity
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_history.*
import javax.inject.Inject


class HistoryFragment : Fragment(),HistoryContract.View, HistoryAdapter.OnItemClickListener {

    @Inject
    lateinit var presenter: HistoryContract.Presenter

    lateinit var listAdapter: HistoryAdapter

    var listData: MutableList<ProductPromo>? = null

    var viewRoot: View? = null


    fun newInstance(): HistoryFragment {
        return HistoryFragment()
    }

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewRoot =  inflater.inflate(R.layout.fragment_history, container, false)

        return viewRoot
    }

    fun setAdapterProduct() {
        with(rvProduct){
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            listAdapter = listData?.let { HistoryAdapter(this@HistoryFragment, it) }!!
            adapter = listAdapter
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.getListData()
    }

    override fun showListData(productPromo: MutableList<ProductPromo>) {
        listData = productPromo
        setAdapterProduct()
        listAdapter.notifyDataSetChanged()
    }

    override fun showDialog() {

    }

    override fun hideDialog() {

    }
    override fun onItemProductClick(product: ProductPromo?) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra("product",product)
        startActivity(intent)
    }


    companion object {
        val TAG: String = "HistoryFragment"

    }

}
