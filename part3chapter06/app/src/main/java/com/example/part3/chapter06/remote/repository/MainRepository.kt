package com.example.part3.chapter06.remote.repository

import androidx.paging.PagingData
import com.example.part3.chapter06.model.ListItem
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    fun loadList() : Flow<PagingData<ListItem>>
}