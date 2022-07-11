
package com.zawmoehtike.network.di

import com.squareup.moshi.Moshi
import com.zawmoehtike.network.BuildConfig
import com.zawmoehtike.network.service.MyHealthyFruitsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

  @Singleton
  @Provides
  fun okHttpClient(): OkHttpClient {
    return OkHttpClient
      .Builder()
      .connectTimeout(180, TimeUnit.SECONDS)
      .writeTimeout(180, TimeUnit.SECONDS)
      .readTimeout(100, TimeUnit.SECONDS)
      .build()
  }

  @Provides
  @Singleton
  fun retrofit(okHttpClient: OkHttpClient): Retrofit {
    val baseUrl = BuildConfig.BASE_URL

    val moshi = Moshi.Builder()
      .build()
    return Retrofit.Builder()
      .baseUrl(baseUrl)
      .addConverterFactory(MoshiConverterFactory.create(moshi))
      .client(okHttpClient)
      .build()
  }

  @Provides
  @Singleton
  fun myHealthyFruitsService(retrofit: Retrofit): MyHealthyFruitsService {
    return retrofit.create(MyHealthyFruitsService::class.java)
  }
}