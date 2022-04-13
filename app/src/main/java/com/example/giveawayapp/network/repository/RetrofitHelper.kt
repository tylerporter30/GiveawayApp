package com.example.giveawayapp.network.repository

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitHelper {

    private val retrofit: Retrofit

    init {

        val builder = Retrofit.Builder()
            .baseUrl("https://private-37ad8-new4u.apiary-mock.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())

        //this is optional but good practice to do
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        //this is optional but good practice to do
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .writeTimeout(0, TimeUnit.MILLISECONDS)  //initial connection
            .writeTimeout(2, TimeUnit.MINUTES)  //minutes set to establish connection to server
            .writeTimeout(1, TimeUnit.MINUTES).build()

        retrofit = builder.client(okHttpClient).build()
    }

    fun getAuthService(): AuthAPIService {

        return retrofit.create(AuthAPIService::class.java)

    }
}