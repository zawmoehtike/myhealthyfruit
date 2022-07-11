package com.zawmoehtike.network.di

import com.zawmoehtike.data.datasource.fruits.FruitNetworkDataSource
import com.zawmoehtike.network.datasource.fruits.FruitNetworkDataSourceRealImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class NetworkDataSourceModule {
    @Binds
    abstract fun fruitNetworkDataSource(fruitNetworkDataSourceRealImpl: FruitNetworkDataSourceRealImpl): FruitNetworkDataSource
}