package com.example.giveawayapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.giveawayapp.ui.theme.Purple500
import com.example.giveawayapp.ui.theme.Shapes

class DonationCreate : ComponentActivity() {

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                topBar = {

                    TopAppBar(
                        backgroundColor = colorResource(id = R.color.purple_500),
                        title = {
                            Text(
                                "Create Donation",
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
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    CreateDonationButton()
                }
            }
        }
    }
}


@Composable
fun CreateDonationButton() {

    val context = LocalContext.current
    Column(

        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(1.dp)
    )
    {

        var itemName by rememberSaveable { mutableStateOf(value = "") }
        var description by rememberSaveable { mutableStateOf(value = "") }
        var location by rememberSaveable { mutableStateOf(value = "") }
        var tags by rememberSaveable { mutableStateOf(value = "") }


        TextField(
            value = itemName,
            onValueChange = { itemName = it },
            label = {
                Text(
                    text = "Item Name",
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.W500,
                    fontSize = 18.sp
                )
            },

            modifier = Modifier
                .padding(top = 10.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
                .clip(Shapes.medium)

        )

        TextField(
            value = description,
            onValueChange = { description = it },
            label = {
                Text(
                    text = "Description",
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.W500,
                    fontSize = 18.sp
                )
            },
            modifier = Modifier
                .padding(top = 10.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
                .clip(Shapes.medium)
        )

        TextField(
            value = location,
            onValueChange = { location = it },
            label = {
                Text(
                    text = "Location",
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.W500,
                    fontSize = 18.sp
                )
            },
            modifier = Modifier
                .padding(top = 10.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
                .clip(Shapes.medium)
        )

        TextField(
            value = tags,
            onValueChange = { tags = it },
            label = {
                Text(
                    text = "Tags",
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.W500,
                    fontSize = 18.sp
                )
            },
            modifier = Modifier
                .padding(top = 10.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
                .clip(Shapes.medium)
        )

        val backgroundColor = Color(0xFF673AB7)
        Button(
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),
            modifier = Modifier
                .padding(top = 5.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth(),
            onClick = {
                context.startActivity(Intent(context, Home::class.java))
                Toast.makeText(context, "Donation Created!", Toast.LENGTH_SHORT).show()
            })
        {
            Text(
                text = "Create Donation",
                color = Color.White,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.W600,
                fontSize = 20.sp,
                modifier = Modifier.padding(1.dp)
            )
        }
    }
    //Divider()
    CancelButton1()
}

