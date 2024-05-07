package io.seoj17.android_14th_compose_zzik.data.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.seoj17.android_14th_compose_zzik.data.api.UpBitApi
import io.seoj17.android_14th_compose_zzik.data.quilifier.UpBitBaseUrl
import io.seoj17.android_14th_compose_zzik.data.quilifier.UpBitWebSocketRequest
import io.seoj17.android_14th_compose_zzik.data.quilifier.UpBitWebSocketUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Singleton
    @Provides
    @UpBitBaseUrl
    fun provideUpBitBaserUrl(): String {
        return "https://api.upbit.com"
    }

    @Singleton
    @Provides
    @UpBitWebSocketUrl
    fun provideUpBitWebSocketUrl(): String {
        return "wss://api.upbit.com/websocket/v1"
    }

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Singleton
    @Provides
    fun provideMoshi(): Moshi {
        return Moshi
            .Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Singleton
    @Provides
    fun provideClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient {
        return OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideUpBitRetrofit(
        okHttpClient: OkHttpClient,
        moshi: Moshi,
        @UpBitBaseUrl url: String,
    ): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(url)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    @UpBitWebSocketRequest
    fun provideWebSocketRequest(
        @UpBitWebSocketUrl url: String,
    ): Request {
        return Request
            .Builder()
            .url(url)
            .build()
    }

    @Singleton
    @Provides
    fun provideUpBitApi(retrofit: Retrofit): UpBitApi {
        return retrofit.create(UpBitApi::class.java)
    }
}
