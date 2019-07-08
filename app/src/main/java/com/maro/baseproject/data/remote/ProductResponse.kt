package com.maro.baseproject.data.remote
import com.google.gson.annotations.SerializedName
import com.maro.baseproject.data.local.Category
import com.maro.baseproject.data.local.ProductPromo


/**
 * Created by Wanhar on 28/06/19.
 * Email : Wanhardaengmaro@gmail.com
 */
data class ProductResponse(
    @SerializedName("data")
    var `data`: Data?
)

data class Data(
    @SerializedName("category")
    var category: List<Category?>?,
    @SerializedName("productPromo")
    var productPromo: List<ProductPromo?>?
)
