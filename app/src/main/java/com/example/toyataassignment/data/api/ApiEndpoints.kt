package com.example.toyataassignment.data.api

import com.example.toyataassignment.data.model.ProductModel
import com.example.toyataassignment.data.model.ProductsModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/*
Specify API endpoints abstract methods with repository would
need to be injected into ApiRepositoryImpl
 */
interface ApiEndpoints {

    @GET(ApiDetails.ENDPOINT_PRODUCTS)
    suspend fun getAllProducts(): ProductsModel //Return all products

    @GET(ApiDetails.ENDPOINT_PRODUCT_DETAILS)
    suspend fun getProductDetails(@Path("productId") productId: Int?): ProductModel //a specific product based on Id

}