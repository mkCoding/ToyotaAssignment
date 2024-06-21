package com.example.toyataassignment.ui.product_details

import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import com.example.toyataassignment.ui.product_list.ProductsListScreen
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
//    IconButton(
//        onClick = { onBack() },
//        modifier = Modifier
//            .padding(16.dp)
//    ) {
//        Icon(
//            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
//            contentDescription = "Back",
//            tint = Color.Black,
//            modifier = Modifier.size(100.dp)
//        )
//    }


Column(
    modifier = Modifier
        .fillMaxSize()
        .padding(top = 8.dp),
    horizontalAlignment = Alignment.CenterHorizontally

) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 3.dp)
    ) {
        IconButton(
            onClick = { onBack() },
            modifier = Modifier.size(50.dp)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back",
                tint = Color.Black,
                modifier = Modifier.size(50.dp)
            )
        }

        Spacer(modifier = Modifier.width(40.dp))

        Text(
            text = "Products Details",
            style = TextStyle(fontSize = 30.sp),
            modifier = Modifier.weight(1f)
        )
    }

    HorizontalDivider(
        modifier = Modifier
            .padding(vertical = 10.dp)
            .width(350.dp),
        color = Color.Black,
        thickness = 3.dp
    )


    DetailsCard(product)
}

}

@Composable
fun DetailsCard (product: ProductModel?){
    Card (modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(16.dp),

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
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 15.sp, textAlign = TextAlign.Center)

                )

        }


        //Add end bracket here

    }
}


@Composable
fun backButton(onBack: () -> Unit){

    Column(
        modifier = Modifier
            .wrapContentHeight()

    ){

//        Spacer(modifier = Modifier.height(50.dp)) // Add a spacer above the button
        Button(
            onClick = {onBack()},
            modifier = Modifier
                .wrapContentWidth()
                .padding(10.dp)
                .padding(top = 8.dp, start = 4.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),

            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 2.dp,
                pressedElevation = 8.dp,
                disabledElevation = 0.dp,
                hoveredElevation = 2.dp,
                focusedElevation = 4.dp
            ),
            shape = RoundedCornerShape(size = 15.dp)


        ){
            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .wrapContentWidth()

            ){
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null,
                    modifier = Modifier
                        .size(50.dp),
                    tint = Color.Black
                )
            }
        }
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