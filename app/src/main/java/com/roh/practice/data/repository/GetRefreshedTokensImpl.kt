package com.roh.practice.data.repository

import androidx.work.*
import com.roh.practice.domain.repository.GetRefreshedTokens
import com.roh.practice.domain.util.WorkerKeys
import com.roh.practice.domain.workmanager.DemoWorkManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetRefreshedTokensImpl
@Inject
constructor(

) : GetRefreshedTokens {

    override suspend fun getRefreshedTokens(): String {
        return ""
    }

}