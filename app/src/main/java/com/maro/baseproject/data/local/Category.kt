package com.maro.baseproject.data.local

import com.google.gson.annotations.SerializedName

/**
 * Created by Wanhar on 28/06/19.
 * Email : Wanhardaengmaro@gmail.com
 */
data class Category(
    @SerializedName("id")
    var id: Int?,
    @SerializedName("imageUrl")
    var imageUrl: String?,
    @SerializedName("name")
    var name: String?
)