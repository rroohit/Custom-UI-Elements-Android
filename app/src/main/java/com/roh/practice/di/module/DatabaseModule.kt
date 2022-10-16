package com.roh.practice.di.module

import android.content.Context
import androidx.room.Room
import com.roh.practice.data.local.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDataBase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "Token_Database"
    ).build()


    @Singleton
    @Provides
    fun provideTokenDao(appDatabase: AppDatabase) = appDatabase.getTokenDao()


}