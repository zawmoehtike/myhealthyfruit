package com.zawmoehtike.cache.di

import com.zawmoehtike.cache.datasource.FruitCacheDataSourceRealImpl
import com.zawmoehtike.data.datasource.fruits.FruitCacheDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class CacheDataSourceModule {
    @Binds
    abstract fun fruitCacheDataSource(fruitCacheDataSourceRealImpl: FruitCacheDataSourceRealImpl): FruitCacheDataSource
}