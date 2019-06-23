package com.maro.baseproject.api

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Wanhar on 22/06/19.
 * Email : Wanhardaengmaro@gmail.com
 */
interface ApiService {

    @GET("account/reset_pass")
    fun resetPassword(@Query("email") email: String): Observable<String>
}
