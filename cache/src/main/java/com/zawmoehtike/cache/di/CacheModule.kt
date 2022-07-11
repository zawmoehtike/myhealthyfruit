
package com.zawmoehtike.cache.di

import android.content.Context
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import com.zawmoehtike.cache.MyHealthyFruitsDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import javax.inject.Singleton
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object CacheModule {

    @Provides
    @Singleton
    fun sqlDriver(context: Context): SqlDriver {
        return AndroidSqliteDriver(MyHealthyFruitsDB.Schema, context, "my_healthy_fruits.db")
    }

    @Provides
    @Singleton
    fun database(sqlDriver: SqlDriver): MyHealthyFruitsDB {
        return MyHealthyFruitsDB(
            driver = sqlDriver
        )
    }
}