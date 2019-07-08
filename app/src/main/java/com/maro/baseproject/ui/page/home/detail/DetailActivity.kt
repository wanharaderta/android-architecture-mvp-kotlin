package com.maro.baseproject.ui.page.home.detail

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.maro.baseproject.R
import com.maro.baseproject.api.RealmService
import com.maro.baseproject.data.local.ProductPromo
import com.maro.baseproject.ui.base.BaseActivity
import com.maro.baseproject.utils.loadImage
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject


class DetailActivity : BaseActivity() {

    @Inject
    lateinit var realmService:RealmService

    var product: ProductPromo? = null
    var productID:String=""
    var productPromo: List<ProductPromo>? = null


    @SuppressLint("ShowToast")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        product = intent.getParcelableExtra<ProductPromo>("product")


        with(product){
            supportActionBar?.title = this?.title
            loadImage(applicationContext, this?.imageUrl,ivProduct)
            if (this?.loved == 1){
                ivFavorite.setImageDrawable(applicationContext.getDrawable(R.mipmap.ic_favorite))
            }
            tvPrice.text = this?.price
            tvNameProduct.text = this?.title
            tvDesc.text = this?.description

        }

        btnBuy.setOnClickListener {
            product?.let { it1 -> realmService.addHistoryAsync(it1) }
            Toast.makeText(this,"Sudah di tambahkan",Toast.LENGTH_SHORT).show()
        }
    }
}
