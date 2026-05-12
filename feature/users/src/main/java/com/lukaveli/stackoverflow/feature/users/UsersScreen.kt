package com.lukaveli.stackoverflow.feature.users

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.lukaveli.stackoverflow.core.domain.model.User
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UsersScreen(
    viewModel: UsersViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.effect.collectLatest { effect ->
            when (effect) {
                is UsersContract.Effect.ShowToast -> {
                    Toast.makeText(context, effect.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Top 20 StackOverflow Users") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                )
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            when (val currentState = state) {
                is UsersContract.State.Loading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
                is UsersContract.State.Error -> {
                    ErrorState(
                        message = currentState.message,
                        onRetry = { viewModel.handleEvent(UsersContract.Event.LoadUsers) }
                    )
                }
                is UsersContract.State.Success -> {
                    if (currentState.users.isEmpty()) {
                        EmptyState()
                    } else {
                        UsersList(
                            users = currentState.users,
                            onToggleFollow = { userId ->
                                viewModel.handleEvent(UsersContract.Event.ToggleFollow(userId))
                            },
                            contentPadding = paddingValues
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun UsersList(
    users: List<User>,
    onToggleFollow: (Long) -> Unit,
    contentPadding: PaddingValues
) {
    LazyColumn(
        contentPadding = PaddingValues(
            top = contentPadding.calculateTopPadding() + 16.dp,
            bottom = contentPadding.calculateBottomPadding() + 16.dp,
            start = 16.dp,
            end = 16.dp
        ),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(users, key = { it.id }) { user ->
            UserItem(user = user, onToggleFollow = { onToggleFollow(user.id) })
        }
    }
}

@Composable
fun UserItem(
    user: User,
    onToggleFollow: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(user.profileImageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = "${user.name} profile image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(Color.LightGray)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = user.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "Reputation: ${user.reputation}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                if (user.isFollowed) {
                    Text(
                        text = "Following",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = onToggleFollow,
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (user.isFollowed) MaterialTheme.colorScheme.errorContainer else MaterialTheme.colorScheme.primaryContainer,
                    contentColor = if (user.isFollowed) MaterialTheme.colorScheme.onErrorContainer else MaterialTheme.colorScheme.onPrimaryContainer
                ),
                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp)
            ) {
                Text(
                    text = if (user.isFollowed) "Unfollow" else "Follow",
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Composable
fun ErrorState(message: String, onRetry: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Oops! Something went wrong.",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = message,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.error
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onRetry) {
            Text("Retry")
        }
    }
}

@Composable
fun EmptyState() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(
            text = "No users found.",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
