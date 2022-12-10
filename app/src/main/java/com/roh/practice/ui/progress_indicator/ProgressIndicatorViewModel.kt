package com.roh.practice.ui.progress_indicator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProgressIndicatorViewModel
@Inject constructor(

) : ViewModel() {

    private val _progress = MutableStateFlow(0)
    val progress: StateFlow<Int> = _progress

    init {

        viewModelScope.launch {
            updateProgress()
        }

    }

    private suspend fun updateProgress() {
        delay(2000)
        _progress.emit(progress.value + 1)
        if (progress.value < 100) updateProgress()
    }

}