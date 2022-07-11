package com.zawmoehtike.myhealthyfruits.di

import com.zawmoehtike.data.repositoryimpl.FruitRepositoryRealImpl
import com.zawmoehtike.domain.repository.FruitRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {
    @Binds
    abstract fun fruitRepository(fruitRepositoryRealImpl: FruitRepositoryRealImpl): FruitRepository
}