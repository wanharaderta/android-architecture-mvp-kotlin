package com.maro.baseproject.api

import com.maro.baseproject.data.local.ProductPromo
import io.realm.Realm
import io.realm.RealmResults
import io.realm.kotlin.createObject
import io.realm.kotlin.where


/**
 * Created by Wanhar on 28/06/19.
 * Email : Wanhardaengmaro@gmail.com
 */
class RealmService(private val mRealm: Realm) {

    val allHistorys: RealmResults<ProductPromo>
        get() = mRealm.where<ProductPromo>().findAll()

    fun isProductExist(id: String): Boolean {
        return if (mRealm.where<ProductPromo>().equalTo("id", id).count() > 0)
            false
        else
            true
    }
    fun addHistoryAsync(productPromo: ProductPromo){
        mRealm.executeTransaction {
            if (isProductExist(productPromo.id.toString())){
                val product  = mRealm.createObject<ProductPromo>(productPromo.id)
                product.title = productPromo.title
                product.description = productPromo.description
                product.imageUrl = productPromo.imageUrl
                product.loved = productPromo.loved
                product.price = productPromo.price
            }
        }
    }

    fun closeRealm() {
        mRealm.close()
    }
}