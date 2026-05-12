# StackOverflow Users

A modern Android application built to display a list of the top 20 StackOverflow users and allow users to toggle a local "follow" status. 

## Features
- Fetches the top 20 users from the StackExchange API.
- Displays user's profile image, name, and reputation.
- Supports toggling a local "Follow" state (simulated locally, persisted across app restarts).
- Displays empty and error states when the server is unavailable or returns no data.

## Installation Requirements
- Android Studio Ladybug (or higher) with Kotlin 2.2+.
- Android API Level 26+ (Minimum SDK).
- An active internet connection for fetching users.

## Architecture and Technical Decisions

This project follows **Clean Architecture** principles, a strict **Unidirectional Data Flow (UDF)**, and is structured using a **Multi-Module Architecture** powered by **Gradle Convention Plugins**.

### Multi-Module Structure
To ensure massive scalability and strict boundary enforcement, the project is divided into several independent modules:
- **`:build-logic`**: Centralized build configuration using custom Gradle convention plugins (`AndroidLibraryConventionPlugin`, `AndroidFeatureConventionPlugin`, etc.).
- **`:app`**: The application composition root. Extremely lean, responsible only for wiring the dependency graph.
- **`:core:domain`**: Contains pure business logic and interfaces (`User`, `UserRepository`, UseCases). It has zero dependencies on Android or specific implementations.
- **`:core:data`**: Contains network models, DataStore implementations, and the concrete `UserRepositoryImpl`.
- **`:feature:users`**: Contains the Jetpack Compose UI, ViewModels, and UI-specific state management.

### Presentation Layer (Jetpack Compose + MVVM/MVI)
- **Jetpack Compose:** Used exclusively for all UI components. This allows for declarative, easily composable, and reactive interfaces.
- **MVI Pattern (Model-View-Intent):** The `UsersViewModel` implements an MVI-like structure. It exposes a single `StateFlow<UsersContract.State>` to the UI and processes incoming `UsersContract.Event`s. This ensures predictable state mutations.

### Domain Layer (Clean Architecture)
- Contains business rules and Use Cases (`GetUsersUseCase`, `ToggleFollowUserUseCase`).
- Keeps the ViewModel lean, making testing straightforward as Use Cases can be easily mocked.
- Defines core `User` model, decoupling the presentation layer from the network data transfer objects (DTOs).

### Data Layer
- **Retrofit & Kotlinx Serialization:** Handled network requests cleanly and safely parses JSON directly into immutable Kotlin data classes (`UserDto`).
- **Jetpack DataStore (Preferences):** Used for storing the "Followed" state locally. Since the requirement is just persisting a set of followed user IDs, DataStore provides a lightweight, reactive (`Flow`-based), and fully asynchronous approach without the overhead of Room.

### Testing Strategy
- **Unit Tests:** `UsersViewModel` and `UserRepositoryImpl` are thoroughly unit tested.
- **MockK:** Used for concise dependency mocking.
- **Turbine:** Integrated for elegant and synchronous-looking asynchronous `Flow` testing. This guarantees that `combine` operations and states are emitted in exactly the correct sequence.

### Dependency Injection
- **Hilt:** Chosen for compile-time safety and standard modern Android DI. Separated into `NetworkModule`, `DataStoreModule`, and `RepositoryModule` for scoping rules.

### Image Loading
- **Coil:** Integrated effortlessly with Compose using `AsyncImage` for crossfading placeholder images and seamless caching.

## Author
Luka Veli (com.lukaveli.stackoverflow)
