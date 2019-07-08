package com.maro.baseproject.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.MemoryCategory
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions

/**
 * Created by Wanhar on 28/06/19.
 * Email : Wanhardaengmaro@gmail.com
 */


internal fun loadImage(context: Context, url: String?, imageView: ImageView) {

    fun setMemoryCategory(context: Context) {
        Glide.get(context).setMemoryCategory(MemoryCategory.NORMAL)
    }

    setMemoryCategory(context)
    GlideApp.with(context)
            .load(url)
            .apply(
                RequestOptions().transforms(CenterCrop())
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE))
            .into(imageView)
}

internal fun loadRoundedBitmap(context: Context, url: String?, imageView: ImageView) {

    fun setMemoryCategory(context: Context) {
        Glide.get(context).setMemoryCategory(MemoryCategory.NORMAL)
    }

    setMemoryCategory(context)
    GlideApp.with(context)
            .asBitmap()
            .load(url)
            .apply(RequestOptions().circleCrop())
            .into(imageView)

}