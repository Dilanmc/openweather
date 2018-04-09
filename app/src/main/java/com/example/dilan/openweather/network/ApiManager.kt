package com.example.dilan.openweather.network

import com.example.dilan.openweather.BuildConfig
import com.example.dilan.openweather.Constants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

object ApiManager {
    private lateinit var endpointApi: EndpointApi

    init {
        val retrofit = initRetrofit()
        init(retrofit)
    }


    private fun initRetrofit(): Retrofit {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        var builder = OkHttpClient.Builder()

        if (BuildConfig.DEBUG) {
            builder.addInterceptor(loggingInterceptor)
        }

        val okClient = builder.apply {
            networkInterceptors().add(Interceptor { chain ->
                val original = chain.request()
                val request = original.newBuilder()
                        .method(original.method(), original.body())
                        .build()
                chain.proceed(request)
            })
        }

        return Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(createMoshiConverter())
                .baseUrl(Constants.WEB_URL)
                .client(okClient.build())
                .build()
    }

    private fun createMoshiConverter(): MoshiConverterFactory = MoshiConverterFactory.create()


    private fun init(retrofit: Retrofit) {
        endpointApi = retrofit.create(EndpointApi::class.java)
    }

    fun loadWeather(parameters: Map<String, String>) =
            endpointApi.getWeather(parameters)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())!!

    fun loadListWeather(parameters: Map<String, String>) =
            endpointApi.getListWeather(parameters)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())!!

}