package com.lukaveli.stackoverflow.core.domain.model

data class User(
    val id: Long,
    val name: String,
    val reputation: Long,
    val profileImageUrl: String?,
    val isFollowed: Boolean = false
)
