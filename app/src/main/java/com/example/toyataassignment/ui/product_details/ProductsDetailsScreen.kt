package com.example.toyataassignment.ui.product_details

import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import com.example.toyataassignment.ui.product_list.ProductsListScreen
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.toyataassignment.data.model.ProductModel

@Composable
fun ProductListDetailsScreen(
    product: ProductModel?,
    onBack: () -> Unit
)
{

Column(
    modifier = Modifier
        .fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally

) {
    Text(
        text = "Product Details",
        style = TextStyle(fontSize = 30.sp),
        modifier = Modifier.padding(bottom = 38.dp)
    )

    DetailsCard(product)
}

}

@Composable
fun DetailsCard (product: ProductModel?){
    Card (modifier = Modifier
        .fillMaxWidth()
        .height(600.dp)
        .padding(horizontal = 16.dp),

    ) {

            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Text(
                    text = product?.title ?: "",
                    modifier = Modifier
                        .padding(20.dp),
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 25.sp)
                )

                Image(
                    painter = rememberImagePainter(
                        data = product?.thumbnail, // URL of the image
                        builder = {
                            transformations(CircleCropTransformation()) // Optional: apply transformations
                        }
                    ),
                    contentDescription = "Image", // provide a proper content description
                    modifier = Modifier
                        .size(350.dp),
                    contentScale = ContentScale.Fit
                )

                Text(
                    text = product?.description?:"",
                    modifier = Modifier.padding(2.dp),
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 15.sp)

                )

        }


        //Add end bracket here

    }
}


@Preview(showBackground = true)
@Composable
fun ProductListDetailsScreenPreview(){

    val sampleProduct = ProductModel(
        title = "Sample Product",
        description = "This is a sample product description.",
        thumbnail = "https://cdn.dummyjson.co…20Princess/thumbnail.png",
        price = 99.99 // Replace with actual price format as needed
        // Add more fields as per your ProductModel definition
    )
    ProductListDetailsScreen(sampleProduct) {}
}