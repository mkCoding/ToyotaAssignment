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
import androidx.compose.material3.Divider
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.toyataassignment.R
import com.example.toyataassignment.data.model.ProductModel
import com.example.toyataassignment.data.model.ProductsModel

@Composable
fun ProductsListScreen(productListViewModel: ProductListViewModel){

    //get list of all products used
    val productsList by productListViewModel.productList.collectAsState(initial = emptyList()) //variable to accessing list from view model

    Log.d("ProductsListScreen", productsList.toString())

    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Text(
            text = "Products List",
            style = TextStyle(fontSize = 30.sp),
            modifier = Modifier
                .padding(16.dp)
        )

        //navController and ProductViewModel
        ProductsList(productsList)
    }
}

@Composable
fun ProductsList (productsList:List<ProductModel?>?){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 14.dp)
            .padding(bottom = 10.dp)
    ){
        Divider(
            color = Color.Black,
            thickness = 3.dp
        )
    }

    //List of Products
    LazyColumn(modifier = Modifier.height(900.dp)) {

        items(productsList?: emptyList()) { itemiuk ->

            //Card start
            Card(
              modifier = Modifier
                  .fillMaxSize()
                  .fillMaxWidth()
                  .padding(8.dp)

                  )
          {

              Row (
                  verticalAlignment = Alignment.CenterVertically,
                  modifier = Modifier
                      .padding(16.dp)
                      .fillMaxWidth()

              ){

                  Column (
                      modifier = Modifier.padding(16.dp),


                      ){
                      Text(text = "Title: ${itemiuk?.title}", modifier = Modifier.padding(bottom = 5.dp))
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

                         // id = R.drawable.ic_launcher_background


                      ),
                      contentDescription = null, // provide a proper content description
                      modifier = Modifier
                          .size(100.dp)
                      ,
                      contentScale = ContentScale.Fit
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