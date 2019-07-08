package com.maro.baseproject.data.local

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import kotlinx.android.parcel.Parcelize

/**
 * Created by Wanhar on 28/06/19.
 * Email : Wanhardaengmaro@gmail.com
 */
@Parcelize
open class ProductPromo(
    @SerializedName("description")
    var description: String? = "",
    @PrimaryKey
    @SerializedName("id")
    var id: String? = "",
    @SerializedName("imageUrl")
    var imageUrl: String? = "",
    @SerializedName("loved")
    var loved: Int? = 0,
    @SerializedName("price")
    var price: String? = "",
    @SerializedName("title")
    var title: String? = ""
) : Parcelable,RealmObject()

