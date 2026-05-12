package com.lukaveli.stackoverflow.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    @SerialName("user_id")
    val userId: Long,
    @SerialName("display_name")
    val displayName: String,
    @SerialName("reputation")
    val reputation: Long,
    @SerialName("profile_image")
    val profileImage: String? = null
)
