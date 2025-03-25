package com.example.part3.chapter07

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.part3.chapter07.model.ContentEntity
import com.example.part3.chapter07.repository.ContentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InputViewModel @Inject constructor(
    private val contentRepository: ContentRepository
) : ViewModel() {
    private val _doneEvent = MutableLiveData<Unit>()
    val doneEvent: LiveData<Unit> = _doneEvent

    val content = MutableLiveData<String>()
    val memo = MutableLiveData<String?>()

    fun insertData() {
        content.value?.let { content ->
            viewModelScope.launch(Dispatchers.IO) {
                contentRepository.insert(
                    ContentEntity(
                        content = content,
                        memo = memo.value
                    )
                )
                _doneEvent.postValue(Unit)
            }
        }
    }
}