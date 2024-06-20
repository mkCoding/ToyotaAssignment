package com.example.toyataassignment.data.repository

import com.example.toyataassignment.data.model.ProductModel
import com.example.toyataassignment.data.model.ProductsModel
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiRepository {

    //get all products
    suspend fun getAllProducts():ProductsModel

    //get details of a product based on id passed in
    suspend fun getProductDetails(@Path("productId") productId: Int?): ProductModel


}