package com.battagliandrea.marvelapi.core.data.retrofit

import com.battagliandrea.marvelapi.core.BuildConfig
import com.battagliandrea.marvelapi.core.extensions.md5
import java.util.Date
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response = chain.run {

        var request = chain.request()

        val publicKey: String = BuildConfig.apiPublicKey
        val privateKey: String = BuildConfig.apiPrivateKey

        val ts = Date().time
        val encryptString = "$ts$privateKey$publicKey".md5()

        val url = request.url.newBuilder()
                .addQueryParameter("ts", ts.toString())
                .addQueryParameter("apikey", publicKey)
                .addQueryParameter("hash", encryptString)
                .build()

        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}
