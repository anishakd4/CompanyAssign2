package com.developer.anishakd4.indihoodassignment.networking

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://ui-test-dot-indihood-dev-in.appspot.com";
private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .build()

object LoanApi {
    val getLoanService: GetLoanInterface by lazy {
        retrofit.create(GetLoanInterface::class.java)
    }
}