package com.maro.baseproject.ui.page.history

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.maro.baseproject.R
import com.maro.baseproject.data.local.ProductPromo
import com.maro.baseproject.utils.loadImage
import kotlinx.android.synthetic.main.item_product.view.*

/**
 * Created by Wanhar on 28/06/19.
 * Email : Wanhardaengmaro@gmail.com
 */
class HistoryAdapter(
        var homeListener: OnItemClickListener?,
        val list: MutableList<ProductPromo>
) : RecyclerView.Adapter<HistoryAdapter
.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_product,
            parent, false
        )
        return ViewHolder(view,parent.context)
    }


    override fun getItemCount() : Int {
        return list.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViewProduct(list[position],homeListener)
    }

    class ViewHolder(itemView: View?, val context: Context) : RecyclerView.ViewHolder(itemView!!) {

        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        fun bindViewProduct(
            product: ProductPromo?,
            listener: OnItemClickListener?
        ) {
            itemView.tvNameProduct.text = product?.title
            itemView.tvDesc.text = product?.description
            loadImage(context, product?.imageUrl,itemView.ivProduct)

            if (product?.loved == 1){
                itemView.ivFavorite.setImageDrawable(context.getDrawable(R.mipmap.ic_favorite))
            }

            itemView.setOnClickListener {
                if (listener != null) {
                    listener.onItemProductClick(product)
                }
            }
        }
    }


    interface OnItemClickListener {
        fun onItemProductClick(product: ProductPromo?)
    }
}