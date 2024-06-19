package com.example.toyataassignment.ui.product_list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.toyataassignment.data.model.ProductModel
import com.example.toyataassignment.data.repository.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(private val repository: ApiRepository):ViewModel() {

    private val _productList = MutableStateFlow<List<ProductModel?>?>(emptyList())
    val productList: MutableStateFlow<List<ProductModel?>?> = _productList

    init {
        getAllProducts()
    }

    private fun getAllProducts() {
        viewModelScope.launch {
            var allProducts = repository.getAllProducts()

            if(allProducts!=null){

                Log.d("ProductListViewModel", allProducts.toString())


                //this is very important as it will be passed to View
                _productList.emit(allProducts.products)
            }
        }


    }


}