package io.seoj17.android_14th_compose_zzik.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.seoj17.android_14th_compose_zzik.data.BitService
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun providesOkHttpClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun providesBitService(retrofit: Retrofit): BitService = retrofit.create(BitService::class.java)

    @Provides
    @Singleton
    fun providesRequest(): Request =
        Request.Builder()
            .url(WEBSOCKET_URL)
            .build()

    companion object {
        private const val BASE_URL = "https://api.upbit.com/v1"
        private const val WEBSOCKET_URL = "wss://api.upbit.com/websocket/v1"
    }
}
