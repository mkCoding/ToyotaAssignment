package com.example.toyataassignment.data.model


import com.google.gson.annotations.SerializedName

data class ReviewModel(
    @SerializedName("comment")
    val comment: String? = "",
    @SerializedName("date")
    val date: String? = "",
    @SerializedName("rating")
    val rating: Int? = 0,
    @SerializedName("reviewerEmail")
    val reviewerEmail: String? = "",
    @SerializedName("reviewerName")
    val reviewerName: String? = ""
)