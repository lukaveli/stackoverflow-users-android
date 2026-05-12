package com.lukaveli.stackoverflow.core.domain.usecase

import com.lukaveli.stackoverflow.core.domain.repository.UserRepository
import javax.inject.Inject

class ToggleFollowUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(userId: Long) {
        userRepository.toggleFollowState(userId)
    }
}
