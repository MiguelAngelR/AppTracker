package com.mike.network_module.di

import com.mike.apptracker.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton



@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class CoreRetrofit


@Module
@InstallIn(SingletonComponent::class)
internal object CoreNetworkModule {

    private const val BASE_URL: String = BuildConfig.CORE_BASE_URL
    private const val MAX_REQUEST_COUNT = 5
    private const val TIME_OUT_CONNECT = 20L
    private const val TIME_OUT_WRITE = 20L
    private const val TIME_OUT_READ = 20L

    @CoreRetrofit
    @Singleton
    @Provides
    fun provideCoreRetrofit(
        okHttpClient: OkHttpClient,
        converterFactory: Converter.Factory,
    ): Retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(converterFactory)
        .client(okHttpClient).build()


    @Singleton
    @Provides
    fun provideCoreOkHttpClient(
        dispatcher: Dispatcher,
        loggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient = OkHttpClient.Builder().connectTimeout(TIME_OUT_CONNECT, TimeUnit.SECONDS)
        .writeTimeout(TIME_OUT_WRITE, TimeUnit.SECONDS).readTimeout(TIME_OUT_READ, TimeUnit.SECONDS)
        .dispatcher(dispatcher).apply {
            if (BuildConfig.DEBUG) {
                addInterceptor(loggingInterceptor)
                addInterceptor {
                    it.proceed(it.request())
                }
            }
        }.build()


    @Singleton
    @Provides
    fun provideCoreConverter(): Converter.Factory = GsonConverterFactory.create()

    @Singleton
    @Provides
    fun provideCoreHttpLoggingInterceptor() =
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

    @Singleton
    @Provides
    fun provideCoreDispatcher() = Dispatcher().apply { maxRequests = MAX_REQUEST_COUNT }
}