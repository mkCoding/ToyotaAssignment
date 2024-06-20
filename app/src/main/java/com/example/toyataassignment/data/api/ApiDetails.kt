package com.example.toyataassignment.data.api

/*
This files specifies the base url and endpoints that
will be used in the Model
 */
object ApiDetails {
    //API -> https://dummyjson.com/products
    //2nd Screen https://dummyjson.com/products/{selected index from first screen}


    const val BASE_URL = "https://dummyjson.com"
    const val ENDPOINT_PRODUCTS = "/products"
    const val ENDPOINT_PRODUCT_DETAILS = "/products/{productId}" //the productId will passed as path to access this Endpoint
}