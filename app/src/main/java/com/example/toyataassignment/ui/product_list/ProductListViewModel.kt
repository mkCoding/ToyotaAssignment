package com.example.toyataassignment.ui.product_list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.toyataassignment.data.model.ProductModel
import com.example.toyataassignment.data.repository.ApiRepository
import com.example.toyataassignment.state.ProductListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(private val repository: ApiRepository):ViewModel() {

    //Product List
    private val _productList = MutableStateFlow<List<ProductModel?>?>(emptyList())
    val productList: MutableStateFlow<List<ProductModel?>?> = _productList

    //Product Details
    private val _productDetails = MutableStateFlow<ProductModel?>(null)
    val productDetails: MutableStateFlow<ProductModel?> = _productDetails

    //Product List State
    private val _productListState = MutableStateFlow<ProductListState>(ProductListState.Loading)
    val productListState: StateFlow<ProductListState> = _productListState

    init {
        getAllProducts()
    }

    fun getAllProducts() {
        viewModelScope.launch {
            try {
                val allProducts = repository.getAllProducts().products
                if (allProducts != null) {
                    _productListState.value = ProductListState.Success(allProducts)
                    _productList.value = allProducts
                } else {
                    _productListState.value = ProductListState.Error("Failed to Fetch products")
                }
            } catch (e: Exception) {
                _productListState.value = ProductListState.Error(e.message ?: "Unknown error")
            }
        }
    }

    fun getProductById(productId:Int?){
        viewModelScope.launch {
            val product = repository.getProductDetails(productId)
            if(product!=null){
                Log.d("ProductListViewModel", product.toString())
                _productDetails.value = product

            }

        }
    }



    }