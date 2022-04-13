package com.example.giveawayapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.giveawayapp.network.Donation
import com.example.giveawayapp.ui.ItemCard
import com.example.giveawayapp.ui.theme.Shapes


class Social : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun SocialScreen() {

    var request_box by rememberSaveable { mutableStateOf("") }
    var item_description by rememberSaveable { mutableStateOf("") }

    val context = LocalContext.current
    val backgroundColor = Color(0xFF673AB7)

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = colorResource(id = R.color.purple_500),
                title = {
                    Text(
                        "Community Post",
                        color = Color.White,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.W600,
                        fontSize = 25.sp,
                    )
                })
        }
    )
    {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Looking for an item? Let others know what you need!",
                color = colorResource(id = R.color.purple_500),
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.W600,
                fontSize = 25.sp,
                modifier = Modifier.padding(top = 8.dp)
            )

            TextField(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                value = request_box,
                onValueChange = { request_box = it },
                label = {
                    Text(
                        text = "Request Item",
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.W500,
                        fontSize = 18.sp
                    )
                },

                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color(0xFF673AB7),
                    unfocusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(8.dp),
            )

            TextField(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(200.dp),
                value = item_description,
                onValueChange = { item_description = it },
                label = {
                    Text(
                        text = "Why do you need this item?",
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.W500,
                        fontSize = 18.sp
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color(0xFF673AB7),
                    unfocusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(8.dp),
            )

            Button(shape = Shapes.medium,
                colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),
                modifier = Modifier
                    .padding(top = 5.dp, bottom = 5.dp, start = 15.dp, end = 15.dp)
                    .fillMaxWidth(),

                onClick = {
                    //Traverses to the Home page
                    Toast.makeText(context, "Item Search Posted", Toast.LENGTH_SHORT).show()
                    context.startActivity(Intent(context, Home::class.java))

                }) {
                Text(
                    text = "Submit",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.W600,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(1.dp)
                )
            }
            CancelButton1()

//            val context = LocalContext.current
//            TextButton(
//                onClick = {
//                    context.startActivity(Intent(context, Profile::class.java))
//                    Toast.makeText(context, "Returning Home....", Toast.LENGTH_SHORT).show()
//                },
//                modifier = Modifier.absolutePadding(top = 100.dp)
//
//            ) {
//                Text(
//                    "Cancel",
//                    fontFamily = FontFamily.Serif,
//                    fontWeight = FontWeight.W600,
//                    fontSize = 20.sp,
//                    color = Color(0xFF673AB7)
//                )
//            }
        }
    }
}

@Composable
fun Donations(donations: List<Donation>) {
    LazyColumn(Modifier.padding(15.dp)) {
        items(donations) { donation ->
            ItemCard(donation)
        }
    }
}

//@Composable
//fun SimpleText5(displayText: String) {
//
//    Text(
//        color = Color(0xFF673AB7),
//        text = displayText,
//        style = MaterialTheme.typography.h1,
//        fontSize = 35.sp
//    )
//}