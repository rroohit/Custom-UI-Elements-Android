package com.roh.practice.di

import androidx.work.WorkManager
import com.roh.practice.data.repository.GetRefreshedTokensImpl
import com.roh.practice.domain.repository.GetRefreshedTokens
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRefreshTokenRepo(workManager: WorkManager) : GetRefreshedTokens {
        return GetRefreshedTokensImpl(workManager)
    }


}