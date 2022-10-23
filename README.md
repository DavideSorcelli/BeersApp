# BeersApp
Demo project for Reply Concept Labcamp on Principles &amp; Architectures of a modern app

/**
 *
 * DI RemoteModule
 * - provide okhttp
 * - provide retrofit
 *
 * DI LocalModule
 * - provide BeersDB
 * - provide BeersDAO
 * - provide BeersCategoryDAO
 *
 * DI DataSourceModule
 * - binds BeersLocalSource
 * - binds BeersRemoteSource
 * - binds BeersCategoryLocalSource
 *
 * DI RepositoryModule:
 * - binds BeersRepository
 * - binds BeersCategoryRepository
 *
 * Beers RemoteSource:
 * - suspend fun fetchBeers()
 *
 * Beers LocalSource:
 * - suspend fun save(beers: List<Beer>)
 * - suspend/reactive fun getAll(): List<Beer>
 * - suspend/reactive fun getByIds(beersId: List<Long>): List<Beer>
 *
 * BeersCategory LocalSource
 * - suspend/reactive getAll()
 * - suspend fun create(category: BeerCategory)
 * - suspend fun delete(categoryId: Long) (optional)
 *
 * Beers repo:
 * - suspend/reactive fun getBeers(refresh: Boolean): List<Beer>
 * - suspend/reactive fun getBeersByIds(beersId: List<Long>): List<Beer>
 *
 * BeersCategory repo:
 * - suspend/reactive getCategories()
 * - suspend/reactive getCategoryById(categoryId: Long): Category
 * - suspend fun createCategory(category: BeerCategory)
 * - suspend fun deleteCategory(categoryId: Long) (optional)
 *
 * Use case:
 * - callable/observable GetBeersUC: List<Beer>
 * - callable AddBeersCategoryUC
 * - callable DeleteBeersCategoryUC (optional)
 * - callable/observable GetBeersCategoriesUC: List<BeerCategory>
 * - callable/observable GetBeersFromCategoryUC(catId): List<Beer> (combine BeerCategoryRepo and BeerRepo)
 *
 * Screens:
 * - BeersListScreen (can be reused when user click on BeersCategoriesScreen item)
 * - BeersDetailScreen (optional)
 * - BeersCategoriesScreen
 *
 */
