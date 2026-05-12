package com.lukaveli.stackoverflow.presentation.users;

@kotlin.Metadata(mv = {2, 2, 0}, k = 2, xi = 48, d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007\u001a*\u0010\u0004\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\tH\u0007\u001a\u001e\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0007\u001a\u001e\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0007\u001a\b\u0010\u0012\u001a\u00020\u0001H\u0007\u00a8\u0006\u0013"}, d2 = {"UsersScreen", "", "viewModel", "Lcom/lukaveli/stackoverflow/presentation/users/UsersViewModel;", "UsersList", "users", "", "Lcom/lukaveli/stackoverflow/domain/model/User;", "onToggleFollow", "Lkotlin/Function1;", "", "UserItem", "user", "Lkotlin/Function0;", "ErrorState", "message", "", "onRetry", "EmptyState", "users_debug"})
public final class UsersScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void UsersScreen(@org.jetbrains.annotations.NotNull()
    com.lukaveli.stackoverflow.presentation.users.UsersViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void UsersList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.lukaveli.stackoverflow.domain.model.User> users, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> onToggleFollow) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void UserItem(@org.jetbrains.annotations.NotNull()
    com.lukaveli.stackoverflow.domain.model.User user, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onToggleFollow) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ErrorState(@org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onRetry) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void EmptyState() {
    }
}