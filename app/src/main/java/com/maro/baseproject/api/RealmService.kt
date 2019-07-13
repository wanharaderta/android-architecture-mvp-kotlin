package com.maro.baseproject.api

import android.content.Context
import com.maro.baseproject.data.local.ProductPromo
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmResults
import io.realm.kotlin.createObject
import io.realm.kotlin.where


/**
 * Created by Wanhar on 28/06/19.
 * Email : Wanhardaengmaro@gmail.com
 */
class RealmService(private val mRealm: Realm) {

    companion object{
        fun initDatabase(context: Context){
            Realm.init(context)
            val realmConfiguration = RealmConfiguration.Builder()
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build()
            Realm.setDefaultConfiguration(realmConfiguration)
        }
    }

    val allHistorys: RealmResults<ProductPromo>
        get() = mRealm.where<ProductPromo>().findAll()

    fun isProductExist(id: String): Boolean {
        return mRealm.where<ProductPromo>().equalTo("id", id).count() <= 0
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