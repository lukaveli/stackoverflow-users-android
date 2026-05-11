package com.lukaveli.stackoverflow.data.repository

import com.lukaveli.stackoverflow.data.local.FollowPreferences
import com.lukaveli.stackoverflow.data.remote.StackOverflowApi
import com.lukaveli.stackoverflow.domain.model.User
import com.lukaveli.stackoverflow.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: StackOverflowApi,
    private val followPreferences: FollowPreferences
) : UserRepository {

    override fun getUsers(): Flow<Result<List<User>>> = flow {
        // Fetch network data
        val response = api.getUsers()
        emit(Result.success(response.items))
    }.combine(followPreferences.followedUserIds) { networkResult, followedIds ->
        // Merge network data with local follow state
        networkResult.map { userDtos ->
            userDtos.map { dto ->
                User(
                    id = dto.userId,
                    name = dto.displayName,
                    reputation = dto.reputation,
                    profileImageUrl = dto.profileImage,
                    isFollowed = followedIds.contains(dto.userId)
                )
            }
        }
    }.catch { e ->
        emit(Result.failure(e))
    }

    override suspend fun toggleFollowState(userId: Long) {
        followPreferences.toggleFollowState(userId)
    }
}
