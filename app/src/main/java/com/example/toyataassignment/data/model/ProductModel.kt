package com.example.toyataassignment.data.model


import com.google.gson.annotations.SerializedName

data class ProductModel(
    @SerializedName("availabilityStatus")
    val availabilityStatus: String? = "",
    @SerializedName("brand")
    val brand: String? = "",
    @SerializedName("category")
    val category: String? = "",
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("dimensions")
    val dimensions: DimensionsModel? = DimensionsModel(),
    @SerializedName("discountPercentage")
    val discountPercentage: Double? = 0.0,
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("images")
    val images: List<String?>? = listOf(),
    @SerializedName("meta")
    val meta: MetaModel? = MetaModel(),
    @SerializedName("minimumOrderQuantity")
    val minimumOrderQuantity: Int? = 0,
    @SerializedName("price")
    val price: Double? = 0.0,
    @SerializedName("rating")
    val rating: Double? = 0.0,
    @SerializedName("returnPolicy")
    val returnPolicy: String? = "",
    @SerializedName("reviews")
    val reviews: List<ReviewModel?>? = listOf(),
    @SerializedName("shippingInformation")
    val shippingInformation: String? = "",
    @SerializedName("sku")
    val sku: String? = "",
    @SerializedName("stock")
    val stock: Int? = 0,
    @SerializedName("tags")
    val tags: List<String?>? = listOf(),
    @SerializedName("thumbnail")
    val thumbnail: String? = "",
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("warrantyInformation")
    val warrantyInformation: String? = "",
    @SerializedName("weight")
    val weight: Int? = 0
)