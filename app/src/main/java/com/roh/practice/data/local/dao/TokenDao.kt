package com.roh.practice.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.roh.practice.data.local.dto.TokenDto

/**
 *  DAO => Data access object
 *      - DAO provides the methods that the rest of app interact with data in table.
 *
 */


@Dao
interface TokenDao {

    @Query("SELECT * FROM TokenDto")
    fun getToken(): TokenDto

    @Insert
    fun insertTokens(tokenDto: TokenDto)

    @Delete
    fun deleteToken(tokenDto: TokenDto)

}