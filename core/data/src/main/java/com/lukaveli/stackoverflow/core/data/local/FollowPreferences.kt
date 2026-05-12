package com.lukaveli.stackoverflow.core.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "follow_preferences")

class FollowPreferences(private val dataStore: DataStore<Preferences>) {

    companion object {
        val FOLLOWED_USERS_KEY = stringSetPreferencesKey("followed_users")
    }

    val followedUserIds: Flow<Set<Long>> = dataStore.data
        .map { preferences ->
            preferences[FOLLOWED_USERS_KEY]?.mapNotNull { it.toLongOrNull() }?.toSet() ?: emptySet()
        }

    suspend fun toggleFollowState(userId: Long) {
        dataStore.edit { preferences ->
            val currentSet = preferences[FOLLOWED_USERS_KEY] ?: emptySet()
            val userIdStr = userId.toString()
            
            val newSet = if (currentSet.contains(userIdStr)) {
                currentSet - userIdStr
            } else {
                currentSet + userIdStr
            }
            
            preferences[FOLLOWED_USERS_KEY] = newSet
        }
    }
}
