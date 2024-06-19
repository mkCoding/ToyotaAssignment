package com.example.toyataassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.toyataassignment.ui.product_list.ProductListViewModel
import com.example.toyataassignment.ui.product_list.ProductsListScreen
import com.example.toyataassignment.ui.theme.ToyataAssignmentTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val productListViewModel by viewModels<ProductListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToyataAssignmentTheme {
//                val productListViewModel: ProductListViewModel = hiltViewModel()
              ProductsListScreen(productListViewModel = productListViewModel)
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    ProductsListScreen(productListViewModel ) // You can also preview your TitleScreen directly in Android Studio
//}