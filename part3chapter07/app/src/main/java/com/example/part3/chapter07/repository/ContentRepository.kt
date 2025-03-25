package com.example.part3.chapter07.repository

import com.example.part3.chapter07.model.ContentEntity
import kotlinx.coroutines.flow.Flow

interface ContentRepository {
    fun loadList() : Flow<List<ContentEntity>>
    suspend fun insert(item: ContentEntity)
}