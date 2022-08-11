package com.roh.practice.model

import com.roh.practice.data.HomeDestinations

data class HomeItem(
    val CardId: Int? = null,
    val CardName: String? = null,
    val CardImage: Int? = null,
    val HomeDestination: HomeDestinations? = null,
    val Description: String = "",
    val LastModifyDate: String = ""
)
