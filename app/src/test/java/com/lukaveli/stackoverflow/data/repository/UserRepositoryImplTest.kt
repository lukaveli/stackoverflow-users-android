package com.lukaveli.stackoverflow.data.repository

import app.cash.turbine.test
import com.lukaveli.stackoverflow.data.local.FollowPreferences
import com.lukaveli.stackoverflow.data.remote.StackOverflowApi
import com.lukaveli.stackoverflow.data.remote.model.UserDto
import com.lukaveli.stackoverflow.data.remote.model.UsersResponse
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class UserRepositoryImplTest {

    private lateinit var api: StackOverflowApi
    private lateinit var followPreferences: FollowPreferences
    private lateinit var repository: UserRepositoryImpl

    @Before
    fun setUp() {
        api = mockk()
        followPreferences = mockk()
        repository = UserRepositoryImpl(api, followPreferences)
    }

    @Test
    fun `getUsers combines network data with local follow state correctly`() = runTest {
        // Arrange
        val userId = 1L
        val dto = UserDto(userId, "Jon Skeet", 1000L, "url")
        val response = UsersResponse(listOf(dto))
        val followedIds = setOf(userId)

        coEvery { api.getUsers() } returns response
        every { followPreferences.followedUserIds } returns flowOf(followedIds)

        // Act
        val resultFlow = repository.getUsers()

        // Assert
        resultFlow.test {
            val result = awaitItem()
            assertTrue(result.isSuccess)
            val users = result.getOrNull()!!
            assertEquals(1, users.size)
            assertEquals(userId, users[0].id)
            assertTrue(users[0].isFollowed) // Should be true because it's in the followedIds set
            awaitComplete()
        }
    }

    @Test
    fun `getUsers returns failure when api throws exception`() = runTest {
        // Arrange
        val exception = RuntimeException("Network Error")
        coEvery { api.getUsers() } throws exception
        every { followPreferences.followedUserIds } returns flowOf(emptySet())

        // Act
        val resultFlow = repository.getUsers()

        // Assert
        resultFlow.test {
            val result = awaitItem()
            assertTrue(result.isFailure)
            assertEquals(exception.message, result.exceptionOrNull()?.message)
            awaitComplete()
        }
    }
}
