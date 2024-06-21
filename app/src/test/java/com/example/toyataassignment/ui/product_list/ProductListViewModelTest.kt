import com.example.toyataassignment.data.model.ProductModel
import com.example.toyataassignment.data.model.ProductsModel
import com.example.toyataassignment.data.repository.ApiRepository
import com.example.toyataassignment.state.ProductListState
import com.example.toyataassignment.ui.product_list.ProductListViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

//@RunWith(MockitoJUnitRunner::class)
@ExperimentalCoroutinesApi
class ProductListViewModelTest {


    //declare a late init variable to mock the repository
    private lateinit var mockRepository: ApiRepository

    //declare lateinit variable for viewmodel
    private lateinit var viewModel: ProductListViewModel

    //create lateinit variable that runs coroutines immediately for testing purposes
    private val testDispatcher = UnconfinedTestDispatcher()

    //this method runs before each test
    @Before
    fun setup() {
        //set main dispatcher to test dispatcher
        Dispatchers.setMain(testDispatcher)

        //initialize the mock repository
        mockRepository = mock()

        //initialize viewmodel with mock repository
        viewModel = ProductListViewModel(mockRepository)
    }

    //this runs after each test
    @After
    fun cleanup() {
        Dispatchers.resetMain() //reset main dispatcher to its origin state
    }

    /*
    This test essentially verifies that when the repository returns a
    successful response, the ViewModel updates its productList
    StateFlow with the correct data.
     */
    @Test
    fun `test getAllProducts success`() = runTest {
        // Mock the response from repository
        val mockProductsModel = ProductsModel(
            limit = 10,
            products = listOf(
                ProductModel(id = 1, title = "Product 1"),
                ProductModel(id = 2, title = "Product 2")
            ),
            skip = 0,
            total = 2
        )

        // Use whenever to mock the repository response
        whenever(mockRepository.getAllProducts()).thenReturn(mockProductsModel)

        // Call the method in the view model
        viewModel.getAllProducts()

        // Collect the first emission from the productList StateFlow
        val result = viewModel.productList.first()

        // Assert the result is as expected
        assertEquals(mockProductsModel.products, result)
    }

    @Test
    fun `test getAllProducts failure`() = runTest{

        //mock repository to simulate failure in viewmodel's getAllProducts
        whenever(mockRepository.getAllProducts()).thenThrow(RuntimeException("Network Error"))

        //Call the method in viewmodel
        viewModel.getAllProducts()

        //collect first emission from the productsListState Stateflow
        val result = viewModel.productListState.first { it is ProductListState.Error }

        //Assert the result is as expected. I'm expecting RuntimeException
        assertEquals(ProductListState.Error("Network Error"), result)




    }

}




