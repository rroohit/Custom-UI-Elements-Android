package com.roh.practice.data.local.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *  Data Entity - The following code defines a token data entity.
 *              - Each TokenDto represents a row in a tokenDto table in the app's database
 *
 */

@Entity
data class TokenDto(
    @PrimaryKey(autoGenerate = true)
    val uId: Int? = null,
    @ColumnInfo
    val token: String? = null
)
