package com.example.toyataassignment.state

import com.example.toyataassignment.data.model.ProductModel

sealed class ProductListState {
    object Loading : ProductListState()
    data class Success(val products: List<ProductModel?>?) : ProductListState()
    data class Error(val message: String) : ProductListState()
}