package com.example.toyataassignment

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.toyataassignment.data.model.ProductModel
import com.example.toyataassignment.ui.product_details.ProductListDetailsScreen
import com.example.toyataassignment.ui.product_list.ProductListViewModel
import com.example.toyataassignment.ui.product_list.ProductsListScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    productListViewModel: ProductListViewModel
) {
    NavHost(navController = navController, startDestination = "list") {
        // Destination 1: Product list screen
        composable("list") {
            ProductsListScreen(
                navController = navController,
                productListViewModel = productListViewModel
            )
        }

        // https://dummyjson.com/products/%d?productId=0 (80ms)
        // Destination 2: Product details screen
        composable(
            route = "details/{productId}",
            arguments = listOf(navArgument("productId") { type = NavType.IntType })
        ) { navBackStackEntry ->
            // Get the productId from arguments
            val productId = navBackStackEntry.arguments?.getInt("productId")?:0
            Log.d("AppNavHost", productId.toString())

            // Fetch product details using ViewModel
            LaunchedEffect(productId) {
                productListViewModel.getProductById(productId)
            }

            // Observe productDetails StateFlow to update UI when data is available
            val productDetails by productListViewModel.productDetails.collectAsState()
            Log.d("AppNavHost", productDetails?.title?:"")
            Log.d("AppNavHost", productDetails?.brand?:"")
            Log.d("AppNavHost", productDetails?.description?:"")

            ProductListDetailsScreen(productDetails) { navController.popBackStack()}
//            TestScreen(productDetails) {navController.popBackStack()}
        }
    }
}


