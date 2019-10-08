package com.example.wanandroidkotlin.api

import android.util.Log
import com.example.wanandroidkotlin.R
import com.example.wanandroidkotlin.util.Link
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitUtil {
    companion object {
        /**
         * 创建Retrofit
         */
        fun create(url: String): Retrofit {
            return Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        }

        /**
         * 获取ServiceApi
         */
        fun <T> getService(url: String, service: Class<T>): T {
            return create(url).create(service)
        }

        val retrofitService: RetrofitService = RetrofitUtil.getService(Link.WAN_ANDROID, RetrofitService::class.java)
    }
}