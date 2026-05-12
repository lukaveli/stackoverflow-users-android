package com.lukaveli.stackoverflow.domain.usecase;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b0\u0007H\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/lukaveli/stackoverflow/domain/usecase/GetUsersUseCase;", "", "userRepository", "Lcom/lukaveli/stackoverflow/domain/repository/UserRepository;", "<init>", "(Lcom/lukaveli/stackoverflow/domain/repository/UserRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Result;", "", "Lcom/lukaveli/stackoverflow/domain/model/User;", "domain_debug"})
public final class GetUsersUseCase {
    @org.jetbrains.annotations.NotNull()
    private final com.lukaveli.stackoverflow.domain.repository.UserRepository userRepository = null;
    
    @javax.inject.Inject()
    public GetUsersUseCase(@org.jetbrains.annotations.NotNull()
    com.lukaveli.stackoverflow.domain.repository.UserRepository userRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<kotlin.Result<java.util.List<com.lukaveli.stackoverflow.domain.model.User>>> invoke() {
        return null;
    }
}