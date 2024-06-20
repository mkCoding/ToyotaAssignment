package com.example.toyataassignment.data.repository

import com.example.toyataassignment.data.api.ApiEndpoints
import com.example.toyataassignment.data.model.ProductModel
import com.example.toyataassignment.data.model.ProductsModel
import javax.inject.Inject

class ApiRepositoryImpl @Inject constructor(private val apiEndpoints: ApiEndpoints):ApiRepository {
    override suspend fun getAllProducts(): ProductsModel  = apiEndpoints.getAllProducts()
    override suspend fun getProductDetails(productId: Int?): ProductModel = apiEndpoints.getProductDetails(productId)
}