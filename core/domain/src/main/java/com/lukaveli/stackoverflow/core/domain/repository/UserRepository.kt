package com.lukaveli.stackoverflow.core.domain.repository

import com.lukaveli.stackoverflow.core.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUsers(): Flow<Result<List<User>>>
    suspend fun toggleFollowState(userId: Long)
}
