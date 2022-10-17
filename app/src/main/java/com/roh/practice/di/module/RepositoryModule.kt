package com.roh.practice.di.module

import androidx.work.WorkManager
import com.roh.practice.data.local.dao.TokenDao
import com.roh.practice.data.repository.GetRefreshedTokensImpl
import com.roh.practice.data.repository.TokenWorkerImpl
import com.roh.practice.domain.repository.GetRefreshedTokens
import com.roh.practice.domain.repository.TokenWorker
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideTokenWorker(workManager: WorkManager): TokenWorker {
        return TokenWorkerImpl(workManager)
    }

    @Singleton
    @Provides
    fun provideTokenRepos(
        httpClient: HttpClient,
        tokenDao: TokenDao
    ): GetRefreshedTokens {
        return GetRefreshedTokensImpl(httpClient, tokenDao)
    }


}