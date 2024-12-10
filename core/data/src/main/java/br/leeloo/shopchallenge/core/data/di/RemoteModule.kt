package br.leeloo.shopchallenge.core.data.di

import br.leeloo.shopchallenge.core.data.network.HttpClient
import br.leeloo.shopchallenge.core.data.network.HttpClientImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

internal const val BASE_URL = "" + ""
@Module
@InstallIn(SingletonComponent::class)
internal object RemoteModule {
    private const val READ_TIMEOUT = 15L
    private const val WRITE_TIMEOUT = 10L
    private const val CONNECT_TIMEOUT = 15L

    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
    }

    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .retryOnConnectionFailure(true)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    fun provideConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    fun provideRetrofit(
        client: OkHttpClient,
        factory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(factory)
            .build()
    }

    @Provides
    fun provideHttpClient(
        retrofit: Retrofit
    ): HttpClient {
        return HttpClientImpl(retrofit)
    }
}