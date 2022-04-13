package com.example.giveawayapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontFamily.Companion.Serif
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.W500
import androidx.compose.ui.text.font.FontWeight.Companion.W600
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.giveawayapp.ui.theme.Shapes
import com.example.giveawayapp.viewmodel.CreateAccountViewModel

class CreateAccountView : ComponentActivity() {

    private val viewModel1: CreateAccountViewModel by viewModels()

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                CreateAccountWelcome("Create Account")
                CreateAccountButton1(viewModel1 = viewModel1)
            }
        }
    }
}


@Composable
fun CreateAccountWelcome(displayText: String) {

    Text(
        color = Color(0xFF673AB7),
        text = displayText,
        fontFamily = Serif,
        fontWeight = W600,
        fontSize = 38.sp,
        modifier = Modifier.padding(top = 2.dp)
    )
}

@Composable
fun CreateAccountButton1(viewModel1: CreateAccountViewModel) {

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
                    fontFamily = Serif,
                    fontWeight = W500,
                    fontSize = 18.sp
                )
                        )
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
                    fontFamily = Serif,
                    fontWeight = W500,
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
                    fontFamily = Serif,
                    fontWeight = W500,
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
                    fontFamily = Serif,
                    fontWeight = W500,
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
                    fontFamily = Serif,
                    fontWeight = W500,
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
                    fontFamily = Serif,
                    fontWeight = W500,
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
                    fontFamily = Serif,
                    fontWeight = W500,
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
                    fontFamily = Serif,
                    fontWeight = W500,
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
                    fontFamily = Serif,
                    fontWeight = W500,
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
            shape = Shapes.medium,
            colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),
            modifier = Modifier
                .padding(top = 5.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth(),
            onClick = {
                if (!isError) {
                    viewModel1.createAccount(
                        fullName,
                        username,
                        email,
                        address,
                        city,
                        state,
                        zipCode,
                        password,
                        confirmPassword
                    )
                    //if(viewModel1.successful() == true) {
                    context.startActivity(Intent(context, MainActivity::class.java))
                    Toast.makeText(context, "Account Created!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Please Try Again!", Toast.LENGTH_SHORT).show()
                }
            })
        {
            Text(
                text = "Create Account",
                color = Color.White,
                textAlign = TextAlign.Center,
                fontFamily = Serif,
                fontWeight = W600,
                fontSize = 20.sp,
                modifier = Modifier.padding(1.dp)
            )

        }
        //Calling CancelButton function
        CancelButton()
    }
}

@Composable
fun CancelButton() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        Arrangement.Bottom,
        Alignment.CenterHorizontally
    ) {

        val context = LocalContext.current
        TextButton(
            onClick = {
                context.startActivity(Intent(context, MainActivity::class.java))
                Toast.makeText(context, "Returning to Login Screen....", Toast.LENGTH_SHORT).show()
            },

            ) {
            Text(
                "Cancel",
                fontFamily = Serif,
                fontWeight = W500,
                fontSize = 20.sp,
                color = Color(0xFF673AB7)
            )
        }
    }
}