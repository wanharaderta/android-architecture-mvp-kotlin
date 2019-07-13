package com.maro.baseproject.ui.page.home

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.maro.baseproject.R
import com.maro.baseproject.data.local.Category
import com.maro.baseproject.data.local.ProductPromo
import com.maro.baseproject.data.remote.ProductResponse
import com.maro.baseproject.utils.loadImage
import kotlinx.android.synthetic.main.item_categories.view.*
import kotlinx.android.synthetic.main.item_categories.view.tvName
import kotlinx.android.synthetic.main.item_product.view.*

/**
 * Created by Wanhar on 28/06/19.
 * Email : Wanhardaengmaro@gmail.com
 */
class HomeAdapter(
    val type: Int,
    var homeListener: OnItemClickListener?,
    val list: ProductResponse?
) : RecyclerView.Adapter<HomeAdapter
.ViewHolder>() {

    private var CATEGORY_TYPE = 1
    private var PRODUCT_TYPE = 2

    private var size:Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view: View? = null
        when (viewType) {
            CATEGORY_TYPE -> view = LayoutInflater.from(parent.context).inflate(
                R.layout.item_categories,
                parent, false
            )
            PRODUCT_TYPE -> view = LayoutInflater.from(parent.context).inflate(
                R.layout.item_product,
                parent, false
            )
        }
        return ViewHolder(view,parent.context)
    }

    override fun getItemViewType(position: Int): Int {
        if (type == 1)
            return CATEGORY_TYPE
        else
            return PRODUCT_TYPE
    }

    override fun getItemCount() : Int {
        if(type == 1)
            size = list?.data?.category?.size!!
        else
            if (list != null) {
                size = list.data?.productPromo?.size!!
            }
        return size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder.itemViewType) {
            CATEGORY_TYPE -> holder.bindViewCategories(list?.data?.category?.get(position),homeListener)
            PRODUCT_TYPE -> holder.bindViewProduct(list?.data?.productPromo?.get(position),homeListener)
        }
    }

    class ViewHolder(itemView: View?, val context: Context) : RecyclerView.ViewHolder(itemView!!) {

        fun bindViewCategories(
            category: Category?,
            homeListener: OnItemClickListener?
        ) {
            itemView.tvName.text = category?.name
            loadImage(context, category?.imageUrl,itemView.ivCategories)

            itemView.setOnClickListener {
                if (homeListener != null) {
                    homeListener.onItemCategoriesClick(category?.name)
                }
            }
        }

        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        fun bindViewProduct(
            product: ProductPromo?,
            homeListener: OnItemClickListener?
        ) {
            itemView.tvNameProduct.text = product?.title
            itemView.tvDesc.text = product?.description
            loadImage(context, product?.imageUrl,itemView.ivProduct)

            if (product?.loved == 1){
                itemView.ivFavorite.setImageDrawable(context.getDrawable(R.mipmap.ic_favorite))
            }

            itemView.setOnClickListener {
                if (homeListener != null) {
                    homeListener.onItemProductClick(product)
                }
            }
        }
    }


    interface OnItemClickListener {
        fun onItemCategoriesClick(name: String?)
        fun onItemProductClick(product: ProductPromo?)
    }
}