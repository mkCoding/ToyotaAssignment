package com.example.toyataassignment.ui.product_list

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.toyataassignment.R
import com.example.toyataassignment.data.model.ProductModel
import com.example.toyataassignment.data.model.ProductsModel
import com.example.toyataassignment.state.ProductListState

@Composable
fun ProductsListScreen(navController: NavController, productListViewModel: ProductListViewModel) {
    val productListState by productListViewModel.productListState.collectAsState()

    when (productListState) {
        is ProductListState.Loading -> {
            // Show a loading indicator or skeleton screen
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        is ProductListState.Success -> {
            // Show the list of products
            val productsList = (productListState as ProductListState.Success).products
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                    Text(
                    text = "Products List",
                    style = TextStyle(fontSize = 30.sp),
                    modifier = Modifier
                        .padding(16.dp)
                )
                    HorizontalDivider(
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .width(350.dp),
                        color = Color.Black,
                        thickness = 3.dp
                    )


                ProductsList(navController, productsList)
            }
        }
        is ProductListState.Error -> {
            // Show an error message
            val errorMessage = (productListState as ProductListState.Error).message
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Error: $errorMessage",
                    style = TextStyle(fontSize = 18.sp),
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsList (navController:NavController, productsList:List<ProductModel?>?){


    //List of Products
    LazyColumn(modifier = Modifier.height(900.dp)) {

        items(productsList?: emptyList()) { itemiuk ->

            //Card start
            Card(
              modifier = Modifier
                  .fillMaxSize()
                  .fillMaxWidth()
                  .padding(8.dp),
                onClick = {
                        // Navigate to driver details when card is clicked
                        navController.navigate("details/${itemiuk?.id}")
                }

                  )
          {
              Column (
                  modifier = Modifier
                      .fillMaxWidth()
                      .padding(top = 16.dp),
                  horizontalAlignment = Alignment.CenterHorizontally

              ){
                  Text(
                      text = "Title: ${itemiuk?.title}",
                      modifier = Modifier,
                      style = TextStyle(fontWeight = FontWeight.Bold)
                      // Sets the maximum number of lines to 2

                  )
              }
              Row (
                  verticalAlignment = Alignment.CenterVertically,
                  modifier = Modifier
                      .padding(16.dp)
                      .fillMaxWidth()

              ){


                  Column (
                      modifier = Modifier
                          .padding(16.dp)
                          .padding(end = 16.dp) // Add padding to the right

                      ){

                      Text(text = "Brand: ${itemiuk?.brand}", modifier = Modifier.padding(bottom = 5.dp))
                      Text(text = "Price: ${itemiuk?.price}")

//                      Spacer(modifier = Modifier.width(8.dp))
                  }
                  Spacer(modifier = Modifier.weight(1f))

                  Image(
                      painter = rememberImagePainter(
                          data = itemiuk?.thumbnail, // URL of the image
                          builder = {
                              transformations(CircleCropTransformation()) // Optional: apply transformations
                          }

                      ),
                      contentDescription = null, // provide a proper content description
                      modifier = Modifier
                          .size(100.dp)
                      ,
                      contentScale = ContentScale.Crop
                  )

              }

          }
      }


    }

}


@Preview(showBackground = true)
@Composable
fun ProductListScreenPreview(){
 //ProductsListScreen()
}

class PreviewProductViewModel : ViewModel() {
//    val productsList = MutableLiveData<List<ProductsModel>>(listOf(
//
//
//        var myList: MutableList<ProductModel> = mutableListOf(
//        ProductModel(1, "Product A", "Brand X", 10.0),
//        ProductModel(2, "Product B", "Brand Y", 15.5),
//        ProductModel(3, "Product C", "Brand Z", 20.0)
//    )
//
//        ProductsModel(1, listOf(), 2, 20)
//
//
////        ProductsModel(2,"2", "Alice Johnson"),
////        ProductsModel(3,"3", "Bob Williams"),
////        ProductsModel(4,"4", "Charlie Jones"),
////        ProductsModel(5,"5", "David Brown"),
//
//    ))
}