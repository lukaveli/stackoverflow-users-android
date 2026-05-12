package com.lukaveli.stackoverflow.core.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UsersResponse(
    @SerialName("items")
    val items: List<UserDto>
)
