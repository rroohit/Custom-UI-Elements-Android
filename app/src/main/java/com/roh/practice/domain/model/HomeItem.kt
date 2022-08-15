package com.roh.practice.domain.model

import com.roh.practice.domain.util.HomeDestinations

data class HomeItem(
    val CardId: Int? = null,
    val CardName: String? = null,
    val CardImage: Int? = null,
    val HomeDestination: HomeDestinations? = null,
    val Description: String = "",
    val LastModifyDate: String = ""
)
