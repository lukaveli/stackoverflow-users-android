package com.lukaveli.stackoverflow.core.data.remote;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u0000 \f2\u00020\u0001:\u0001\fJ@\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\b2\b\b\u0003\u0010\n\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\r\u00c0\u0006\u0003"}, d2 = {"Lcom/lukaveli/stackoverflow/core/data/remote/StackOverflowApi;", "", "getUsers", "Lcom/lukaveli/stackoverflow/core/data/remote/model/UsersResponse;", "page", "", "pageSize", "order", "", "sort", "site", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "data_debug"})
public abstract interface StackOverflowApi {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BASE_URL = "https://api.stackexchange.com/";
    @org.jetbrains.annotations.NotNull()
    public static final com.lukaveli.stackoverflow.core.data.remote.StackOverflowApi.Companion Companion = null;
    
    @retrofit2.http.GET(value = "2.2/users")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUsers(@retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "pagesize")
    int pageSize, @retrofit2.http.Query(value = "order")
    @org.jetbrains.annotations.NotNull()
    java.lang.String order, @retrofit2.http.Query(value = "sort")
    @org.jetbrains.annotations.NotNull()
    java.lang.String sort, @retrofit2.http.Query(value = "site")
    @org.jetbrains.annotations.NotNull()
    java.lang.String site, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.lukaveli.stackoverflow.core.data.remote.model.UsersResponse> $completion);
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/lukaveli/stackoverflow/core/data/remote/StackOverflowApi$Companion;", "", "<init>", "()V", "BASE_URL", "", "data_debug"})
    public static final class Companion {
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String BASE_URL = "https://api.stackexchange.com/";
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}