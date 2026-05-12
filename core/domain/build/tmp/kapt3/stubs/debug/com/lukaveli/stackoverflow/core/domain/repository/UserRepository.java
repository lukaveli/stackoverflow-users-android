package com.lukaveli.stackoverflow.core.domain.repository;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00040\u0003H&J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u00a6@\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f\u00c0\u0006\u0003"}, d2 = {"Lcom/lukaveli/stackoverflow/core/domain/repository/UserRepository;", "", "getUsers", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Result;", "", "Lcom/lukaveli/stackoverflow/core/domain/model/User;", "toggleFollowState", "", "userId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_debug"})
public abstract interface UserRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<kotlin.Result<java.util.List<com.lukaveli.stackoverflow.core.domain.model.User>>> getUsers();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object toggleFollowState(long userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}