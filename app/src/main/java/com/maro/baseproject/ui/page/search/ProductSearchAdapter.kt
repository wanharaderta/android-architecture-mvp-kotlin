package com.maro.baseproject.ui.page.search

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.maro.baseproject.R
import com.maro.baseproject.data.local.ProductPromo
import com.maro.baseproject.utils.loadImage
import kotlinx.android.synthetic.main.item_product.view.*

/**
 * Created by Wanhar on 28/06/19.
 * Email : Wanhardaengmaro@gmail.com
 */
class ProductSearchAdapter(
    private val context: Context,
    private val productList: List<ProductPromo>?,
    private val listener: ItemClickListener
) : RecyclerView.Adapter<ProductSearchAdapter.DogModelViewHolder>(), Filterable {
    private var proSearchList: List<ProductPromo>? = null


    class DogModelViewHolder(view: View,val context: Context) : RecyclerView.ViewHolder(view) {

        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        fun bindViewProduct(
            product: ProductPromo?,
            listener: ItemClickListener?
        ) {
            itemView.tvNameProduct.text = product?.title
            itemView.tvDesc.text = product?.description
            loadImage(context, product?.imageUrl,itemView.ivProduct)

            if (product?.loved == 1){
                itemView.ivFavorite.setImageDrawable(context.getDrawable(R.mipmap.ic_favorite))
            }

            itemView.setOnClickListener {
                if (listener != null) {
                    product?.let { listener.onItemClicked(it) }
                }
            }
        }
    }
    init {
        this.proSearchList = productList
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogModelViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return DogModelViewHolder(itemView,parent.context)
    }
    override fun onBindViewHolder(holder: DogModelViewHolder, position: Int) {
        holder.bindViewProduct(proSearchList?.get(position),listener)
    }
    override fun getItemCount(): Int {
        if (proSearchList?.size == null) return 0
        else
        return proSearchList?.size!!
    }
    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence): FilterResults {
                val charString = charSequence.toString()
                if (charString.isEmpty()) {
                    proSearchList = productList
                } else {
                    val filteredList = ArrayList<ProductPromo>()
                    if (productList != null) {
                        for (row in productList) {
                            if (row.title?.toLowerCase()?.contains(charString.toLowerCase())!!) {
                                filteredList.add(row)
                            }
                        }
                    }
                    proSearchList = filteredList
                }
                val filterResults = FilterResults()
                filterResults.values = proSearchList
                return filterResults
            }
            override fun publishResults(charSequence: CharSequence, filterResults: FilterResults) {
                @Suppress("UNCHECKED_CAST")
                proSearchList = filterResults.values as List<ProductPromo>
                notifyDataSetChanged()
            }
        }
    }
    interface ItemClickListener {
        fun onItemClicked(product: ProductPromo)
    }
}