package id.buaja.network

import okhttp3.logging.HttpLoggingInterceptor

/**
 * Created by Julsapargi Nursam on 6/9/20.
 */

fun createLoggingInterceptor(): HttpLoggingInterceptor {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    return interceptor
}