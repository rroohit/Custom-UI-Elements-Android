package com.roh.practice.ui.workmanager

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.OutOfQuotaPolicy
import androidx.work.WorkManager
import com.roh.practice.domain.repository.GetRefreshedTokens
import com.roh.practice.domain.repository.TokenWorker
import com.roh.practice.domain.util.WorkerKeys
import com.roh.practice.domain.workmanager.DemoWorkManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WorkViewModel
@Inject constructor(
    private val tokenWorker: TokenWorker,
    private val workManager: WorkManager,
) : ViewModel() {

    private val _token = MutableStateFlow("Fetching Token...")
    val token: StateFlow<String> = _token

    init {

        viewModelScope.launch {

            workManager.getWorkInfoByIdLiveData(tokenWorker.getRefreshedTokenWorkRequest().id).observeForever { info ->
                if (info != null && info.state.isFinished) {
                    _token.value =  info.outputData.getString(WorkerKeys.TOKEN_STR) ?: "empty"
                }
            }
        }

    }

}