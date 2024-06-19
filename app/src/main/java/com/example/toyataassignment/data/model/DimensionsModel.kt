package com.example.toyataassignment.data.model


import com.google.gson.annotations.SerializedName

data class DimensionsModel(
    @SerializedName("depth")
    val depth: Double? = 0.0,
    @SerializedName("height")
    val height: Double? = 0.0,
    @SerializedName("width")
    val width: Double? = 0.0
)