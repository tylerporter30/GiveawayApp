package com.example.giveawayapp.ui

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.giveawayapp.CreateAccountView
import com.example.giveawayapp.ForgotPasswordView
import com.example.giveawayapp.Home
import com.example.giveawayapp.ui.theme.Shapes
import com.example.giveawayapp.viewmodel.LoginViewModel

@Composable
fun LoginText(displayText: String) {

    Text(
        color = Color(0xFF673AB7),
        text = displayText,
        style = MaterialTheme.typography.h1,
        modifier = Modifier.padding(top = 175.dp),
    )
}

@Composable
fun ForgotPasswordButton() {

    val context = LocalContext.current
    TextButton(
        onClick = {
            context.startActivity(Intent(context, ForgotPasswordView::class.java))
        },
        modifier = Modifier.absolutePadding(left = 220.dp)
    ) {
        Text(
            "Forgot Password",
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.W500,
            fontSize = 18.sp,
            color = Color(0xFF673AB7)
        )
    }
}

@Composable
fun CreateAccountButton() {

    Divider(modifier = Modifier.padding(top = 120.dp), color = Color.LightGray)
    Row() {
        Column(

            modifier = Modifier
                .fillMaxHeight()
                .padding(bottom = 18.dp),
            Arrangement.Bottom
        ) {

            Text(
                text = "Don't have an account?",
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.W500,
                fontSize = 20.sp
            )
        }

        Row() {

            Column(

                modifier = Modifier
                    .fillMaxHeight()
                    .padding(bottom = 10.dp),
                Arrangement.Bottom
            ) {

                val context = LocalContext.current
                TextButton(
                    onClick = {
                        context.startActivity(Intent(context, CreateAccountView::class.java))
                    },

                    ) {
                    Text(
                        "Sign Up",
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.W500,
                        fontSize = 20.sp,
                        color = Color(0xFF673AB7)
                    )
                }
            }
        }
    }
}

@Composable
fun LoginView(viewModel: LoginViewModel) {
    LocalContext.current
    Column(

        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(1.dp),

        )
    {

        var username by rememberSaveable { mutableStateOf("") }
        var password by rememberSaveable { mutableStateOf("") }
        var isError by rememberSaveable { mutableStateOf(false) }
        TextField(
            value = username,
            isError = false,
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
                .padding(top = 35.dp, bottom = 25.dp, start = 15.dp, end = 15.dp)
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
                .padding(bottom = 10.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
                .clip(Shapes.medium)
        )

        //Calling ForgotPasswordButton function that displays 'Forgot Password'
        ForgotPasswordButton()

        isError = username.isEmpty() or password.isEmpty()

        val context = LocalContext.current
        val backgroundColor = Color(0xFF673AB7)

        Button(shape = Shapes.medium,
            colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),

            onClick = {
                //This allows the login button to traverse to Home page
                if (!isError) {
                    viewModel.login(username, password)
                    context.startActivity(Intent(context, Home::class.java))
                    Toast.makeText(context, "Login Successful!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Login Unsuccessful!", Toast.LENGTH_SHORT).show()
                }

            }) {

            Text(
                text = "Login",
                color = Color.White,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.W600,
                fontSize = 20.sp,
                modifier = Modifier.padding(1.dp)
            )
        }
    }

    //Calling CreateAccountButton function that displays 'Sign Up' at the bottom
    CreateAccountButton()
}