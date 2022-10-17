package com.roh.practice.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.roh.practice.data.local.dao.TokenDao
import com.roh.practice.data.local.dto.TokenDto


@Database(entities = [TokenDto::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getTokenDao() : TokenDao
}