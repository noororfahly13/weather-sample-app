package com.example.core.network.setup

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response


class RequestInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        val url: HttpUrl = originalRequest.url.newBuilder()
            .addQueryParameter("APPID", "585ffa7c45d6b1c46412c087f3d77c12").build()
        val newRequest = originalRequest.newBuilder().url(url).build()

        return chain.proceed(newRequest)
    }
}
