package com.example.giveawayapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.giveawayapp.ui.theme.Shapes
import com.example.giveawayapp.viewmodel.CreateAccountViewModel

class EditProfileView : ComponentActivity() {

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
                                "Edit Profile",
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
                    EditAccount()

                }
            }
        }
    }
}

@Composable
fun EditAccount() {
    val context = LocalContext.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(1.dp)
    )
    {
        var fullName by rememberSaveable { mutableStateOf(value = "") }
        var username by rememberSaveable { mutableStateOf(value = "") }
        var email by rememberSaveable { mutableStateOf(value = "") }
        var address by rememberSaveable { mutableStateOf(value = "") }
        var city by rememberSaveable { mutableStateOf(value = "") }
        var state by rememberSaveable { mutableStateOf(value = "") }
        var zipCode by rememberSaveable { mutableStateOf(value = "") }
        var password by rememberSaveable { mutableStateOf(value = "") }
        var confirmPassword by rememberSaveable { mutableStateOf(value = "") }
        var isError by rememberSaveable { mutableStateOf(false) }

        TextField(
            value = fullName,
            onValueChange = { fullName = it },
            isError = false,
            label = {
                (Text(
                    if (isError) "Full Name*" else ("Full Name"),
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.W500,
                    fontSize = 18.sp
                ))
            },

            modifier = Modifier
                .padding(top = 5.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
                .clip(Shapes.medium)
        )

        TextField(
            value = username,
            onValueChange = { username = it },
            label = {
                Text(
                    if (isError) "User Name*" else ("User Name"),
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.W500,
                    fontSize = 18.sp
                )
            },

            modifier = Modifier
                .padding(top = 5.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
                .clip(Shapes.medium)
        )

        TextField(
            value = email,
            onValueChange = { email = it },
            label = {
                Text(
                    if (isError) "Email*" else ("Email"),
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.W500,
                    fontSize = 18.sp
                )
            },

            modifier = Modifier
                .padding(top = 5.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
                .clip(Shapes.medium)
        )

        TextField(
            value = address,
            onValueChange = { address = it },
            label = {
                Text(
                    if (isError) "Address*" else ("Address"),
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.W500,
                    fontSize = 18.sp
                )
            },

            modifier = Modifier
                .padding(top = 5.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
                .clip(Shapes.medium)
        )

        TextField(
            value = city,
            onValueChange = { city = it },
            label = {
                Text(
                    if (isError) "City*" else ("City"),
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.W500,
                    fontSize = 18.sp
                )
            },

            modifier = Modifier
                .padding(top = 5.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
                .clip(Shapes.medium)
        )

        TextField(
            value = state,
            onValueChange = { state = it },
            label = {
                Text(
                    if (isError) "State*" else ("State"),
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.W500,
                    fontSize = 18.sp
                )
            },

            modifier = Modifier
                .padding(top = 5.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
                .clip(Shapes.medium)
        )

        TextField(
            value = zipCode,
            onValueChange = { zipCode = it },
            label = {
                Text(
                    if (isError) "Zip Code*" else ("Zip Code"),
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.W500,
                    fontSize = 18.sp
                )
            },

            modifier = Modifier
                .padding(top = 5.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
                .clip(Shapes.medium)
        )

        TextField(
            value = password,
            onValueChange = { password = it },
            label = {
                Text(
                    if (isError) "Password*" else ("Password"),
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.W500,
                    fontSize = 18.sp
                )
            },

            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .padding(top = 5.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
                .clip(Shapes.medium)
        )

        TextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = {
                Text(
                    if (isError) "Confirm Password*" else ("Confirm Password"),
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.W500,
                    fontSize = 18.sp
                )
            },

            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .padding(top = 5.dp, bottom = 10.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
                .clip(Shapes.medium)
        )
        isError =
            fullName.isEmpty() or
                    username.isEmpty() or
                    email.isEmpty() or
                    address.isEmpty() or
                    city.isEmpty() or
                    state.isEmpty() or
                    zipCode.isEmpty() or
                    password.isEmpty() or
                    confirmPassword.isEmpty()


        val backgroundColor = Color(0xFF673AB7)
        Button(
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),
            modifier = Modifier
                .padding(top = 5.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth(),
            onClick = {
                if (!isError) {

                    context.startActivity(Intent(context, MainActivity::class.java))
                    Toast.makeText(context, "Account Updated!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Please Try Again!", Toast.LENGTH_SHORT).show()
                }
            })
        {
            Text(
                text = "Update",
                color = Color.White,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.W600,
                fontSize = 20.sp,
                modifier = Modifier.padding(1.dp)
            )
        }
        CancelButton1()
    }
}

@Composable
fun CancelButton1() {

    val context = LocalContext.current
    TextButton(
        onClick = {
            context.startActivity(Intent(context, Profile::class.java))
            Toast.makeText(context, "Returning....", Toast.LENGTH_SHORT).show()
        },

        ) {
        Text(
            "Cancel",
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.W600,
            fontSize = 20.sp,
            color = Color(0xFF673AB7)
        )
    }
}


@Composable
fun ReturnHomeButton() {

    Column(
        modifier = Modifier
            .fillMaxSize(), Arrangement.Bottom, Alignment.CenterHorizontally
    ) {

        val context = LocalContext.current
        TextButton(
            onClick = {
                context.startActivity(Intent(context, Home::class.java))
                Toast.makeText(context, "Returning Home....", Toast.LENGTH_SHORT).show()
            },

            ) {
            Text(
                "Return Home",
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.W600,
                fontSize = 20.sp, color = Color(0xFF673AB7)
            )
        }
    }

}