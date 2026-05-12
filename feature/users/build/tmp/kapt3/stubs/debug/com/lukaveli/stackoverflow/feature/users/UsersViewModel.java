package com.lukaveli.stackoverflow.feature.users;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001e"}, d2 = {"Lcom/lukaveli/stackoverflow/feature/users/UsersViewModel;", "Landroidx/lifecycle/ViewModel;", "getUsersUseCase", "Lcom/lukaveli/stackoverflow/core/domain/usecase/GetUsersUseCase;", "toggleFollowUserUseCase", "Lcom/lukaveli/stackoverflow/core/domain/usecase/ToggleFollowUserUseCase;", "<init>", "(Lcom/lukaveli/stackoverflow/core/domain/usecase/GetUsersUseCase;Lcom/lukaveli/stackoverflow/core/domain/usecase/ToggleFollowUserUseCase;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/lukaveli/stackoverflow/feature/users/UsersContract$State;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "_effect", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/lukaveli/stackoverflow/feature/users/UsersContract$Effect;", "effect", "Lkotlinx/coroutines/flow/SharedFlow;", "getEffect", "()Lkotlinx/coroutines/flow/SharedFlow;", "handleEvent", "", "event", "Lcom/lukaveli/stackoverflow/feature/users/UsersContract$Event;", "loadUsers", "toggleFollow", "userId", "", "users_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class UsersViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.lukaveli.stackoverflow.core.domain.usecase.GetUsersUseCase getUsersUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.lukaveli.stackoverflow.core.domain.usecase.ToggleFollowUserUseCase toggleFollowUserUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.lukaveli.stackoverflow.feature.users.UsersContract.State> _state = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.lukaveli.stackoverflow.feature.users.UsersContract.State> state = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableSharedFlow<com.lukaveli.stackoverflow.feature.users.UsersContract.Effect> _effect = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.SharedFlow<com.lukaveli.stackoverflow.feature.users.UsersContract.Effect> effect = null;
    
    @javax.inject.Inject()
    public UsersViewModel(@org.jetbrains.annotations.NotNull()
    com.lukaveli.stackoverflow.core.domain.usecase.GetUsersUseCase getUsersUseCase, @org.jetbrains.annotations.NotNull()
    com.lukaveli.stackoverflow.core.domain.usecase.ToggleFollowUserUseCase toggleFollowUserUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.lukaveli.stackoverflow.feature.users.UsersContract.State> getState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.SharedFlow<com.lukaveli.stackoverflow.feature.users.UsersContract.Effect> getEffect() {
        return null;
    }
    
    public final void handleEvent(@org.jetbrains.annotations.NotNull()
    com.lukaveli.stackoverflow.feature.users.UsersContract.Event event) {
    }
    
    private final void loadUsers() {
    }
    
    private final void toggleFollow(long userId) {
    }
}