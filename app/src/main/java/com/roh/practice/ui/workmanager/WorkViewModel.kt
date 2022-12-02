package com.roh.practice.ui.workmanager

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.OutOfQuotaPolicy
import androidx.work.WorkManager
import com.roh.practice.domain.repository.GetRefreshedTokens
import com.roh.practice.domain.repository.TokenWorker
import com.roh.practice.domain.util.Status
import com.roh.practice.domain.util.WorkerKeys
import com.roh.practice.domain.workmanager.DemoWorkManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WorkViewModel
@Inject constructor(
    private val tokenWorker: TokenWorker,
    private val workManager: WorkManager,
    private val coroutineDispatcher: CoroutineScope,
    private val repo: GetRefreshedTokens
) : ViewModel() {

    private val _token = MutableStateFlow("Fetching Token...")
    val token: StateFlow<String> = _token

    init {

        viewModelScope.launch {

            repo.getNewToken()
                .catch {

                }
                .collect { rsp ->
                    Log.d("VIEW_MODEL", "init : started => ${rsp.status}")
                    when (rsp.status) {
                        Status.LOADING -> {
                            _token.emit("loading")
                        }
                        Status.SUCCESS -> {
                            rsp.data?.let { _token.emit(it.toString()) }

                        }
                        Status.ERROR -> {
                            _token.emit(rsp.message.toString())

                        }
                        Status.CACHED -> {
                            _token.emit("${rsp.data}")

                        }
                        Status.NEEDNEWTOKEN -> {
                            _token.emit("${rsp.message}")

                        }
                        Status.LOGOUT -> {
                            _token.emit("logout")

                        }
                    }
                }

//            workManager.getWorkInfoByIdLiveData(tokenWorker.getRefreshedTokenWorkRequest().id).observeForever { info ->
//                if (info != null && info.state.isFinished) {
//                    _token.value =  info.outputData.getString(WorkerKeys.TOKEN_STR) ?: "empty initial"
//                }
//            }


        }

    }

}