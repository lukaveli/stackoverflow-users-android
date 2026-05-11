package com.lukaveli.stackoverflow.di

import android.content.Context
import com.lukaveli.stackoverflow.data.local.FollowPreferences
import com.lukaveli.stackoverflow.data.local.dataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Provides
    @Singleton
    fun provideFollowPreferences(@ApplicationContext context: Context): FollowPreferences {
        return FollowPreferences(context.dataStore)
    }
}
