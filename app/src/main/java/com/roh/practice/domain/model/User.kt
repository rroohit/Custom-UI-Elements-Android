package com.roh.practice.domain.model

import kotlinx.serialization.Serializable


@Serializable
data class User(
    val userId: String,
    val id: Int,
    val title: String,
    val completed: Boolean
)
