package com.example.toyataassignment.data.model


import com.google.gson.annotations.SerializedName

data class ProductsModel(
    @SerializedName("limit")
    val limit: Int? = 0,
    @SerializedName("products")
    val products: List<ProductModel?>? = listOf(),
    @SerializedName("skip")
    val skip: Int? = 0,
    @SerializedName("total")
    val total: Int? = 0
)