package com.example.part3.chapter07.di

import com.example.part3.chapter07.data.dao.ContentDao
import com.example.part3.chapter07.repository.ContentRepository
import com.example.part3.chapter07.repository.ContentRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {
    @Provides
    @ViewModelScoped
    fun providesContentRepository(contentDao: ContentDao): ContentRepository =
        ContentRepositoryImpl(contentDao)
}