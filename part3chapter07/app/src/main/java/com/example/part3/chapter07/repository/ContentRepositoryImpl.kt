package com.example.part3.chapter07.repository

import com.example.part3.chapter07.data.dao.ContentDao
import com.example.part3.chapter07.model.ContentEntity
import kotlinx.coroutines.flow.Flow

class ContentRepositoryImpl(private val contentDao: ContentDao) : ContentRepository {
    override fun loadList() = contentDao.selectAll()

    override suspend fun insert(item: ContentEntity) {
        contentDao.insert(item)
    }

    override suspend fun modify(item: ContentEntity) {
        contentDao.insert(item)
    }

    override suspend fun delete(item: ContentEntity) {
        contentDao.delete(item)
    }
}