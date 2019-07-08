package com.maro.baseproject.api

import com.maro.baseproject.data.remote.ProductResponse
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by Wanhar on 22/06/19.
 * Email : Wanhardaengmaro@gmail.com
 */
interface ApiService {

    @GET("home")
    fun getListData(): Observable<List<ProductResponse>>
}
