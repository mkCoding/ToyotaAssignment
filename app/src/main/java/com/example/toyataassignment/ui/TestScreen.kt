package com.example.toyataassignment.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.toyataassignment.data.model.ProductModel

@Composable
fun TestScreen(
    product: ProductModel?,
    onBack: () -> Unit

){
    Text(text = product?.title?:"")
    Text(text = "Wow")
}