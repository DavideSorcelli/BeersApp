# BeersApp

### Demo project for Reply Concept Labcamp on Principles &amp; Architectures of a modern app

---

DI ServiceModule
  - provide okhttp
  - provide retrofit 
  
DI DatabaseModule
  - provide BeersDB
  - provide BeersDAO
 
DI SourceModule
  - binds BeersLocalSource
  - binds BeersRemoteSource
  
DI RepositoryModule:
  - binds BeersRepository

DI UseCaseModule
 - binds FetchAndObserveBeersUC
  
BeersRemoteSource:
  - suspend fun getAll(): List<Beer>
  
BeersLocalSource:
  - suspend fun save(beers: List<Beer>)
  - suspend fun getAll(): List<Beer>
  - fun getAllAsFlow(): Flow<List<Beer>>
  
Beers repo:
  - suspend fun fetchBeers(): List<Beer>
  - suspend fun getBeers(): List<Beer>
  - fun observeBeers(): Flow<List<Beer>>

FetchAndObserveBeersUC:
  - fun invoke: Flow<List<Beer>>
  - suspend fun refreshBeers()
  
Compose screens:
  - BeersListScreen with BeerListScreenVM
  - BeersDetailScreen with BeerDetailVM

Unit tests:
- FetchAndObserveBeersUCImplTest (domain layer)
- BeerRepositoryImplTest (data layer)
- TODO (framework layer)
- TODO (presentation layer, vm testing)
