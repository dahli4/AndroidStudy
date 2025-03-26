package com.example.part3.chapter07

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.part3.chapter07.model.ContentEntity
import com.example.part3.chapter07.repository.ContentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val contentRepository: ContentRepository
) : ViewModel() {
    val contentList = contentRepository.loadList()
        .stateIn(
            initialValue = emptyList(),
            started = SharingStarted.WhileSubscribed(5_000),
            scope = viewModelScope
        )

    fun updateItem(item: ContentEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            contentRepository.modify(item)
        }
    }

    fun deleteItem(item: ContentEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            contentRepository.delete(item)
        }
    }
}