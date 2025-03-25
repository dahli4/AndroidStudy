package com.example.part3.chapter07.di

import com.example.part3.chapter07.data.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {
    @Singleton
    @Provides
    fun  providesContentDao(AppDatabase: AppDatabase) = AppDatabase.contentDao()
}