package com.developer.anishakd4.indihoodassignment.networking

import com.developer.anishakd4.indihoodassignment.model.TypeModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface GetLoanInterface {

    @GET("records")
    fun getLoans(): Deferred<HashMap<String, TypeModel>>
}