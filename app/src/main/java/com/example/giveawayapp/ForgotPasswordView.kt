package com.example.giveawayapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.giveawayapp.ui.theme.Shapes
import com.example.giveawayapp.viewmodel.ForgotPasswordViewModel

class ForgotPasswordView : ComponentActivity() {

    private val viewModel2: ForgotPasswordViewModel by viewModels()

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                SimpleText2("Create New Password")

                SubmitButton(viewModel2 = viewModel2)
            }
        }
    }
}

@Composable
fun SimpleText2(displayText: String) {

    Text(
        color = Color(0xFF673AB7),
        text = displayText,
        textAlign = TextAlign.Center,
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.W600,
        fontSize = 33.sp,
        modifier = Modifier.padding(top = 175.dp)
    )
}

@Composable
fun SubmitButton(modifier: Modifier = Modifier, viewModel2: ForgotPasswordViewModel) {

    val context = LocalContext.current
    Column(

        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(1.dp)
    )
    {

        var username by rememberSaveable { mutableStateOf("") }
        var newPasswordInput by rememberSaveable { mutableStateOf("") }
        var confirmPasswordInput by rememberSaveable { mutableStateOf("") }
        var isError by rememberSaveable { mutableStateOf(false) }

        TextField(
            value = username,
            isError = false,
            onValueChange = { username = it },
            label = { Text(if(isError)"User Name*" else("User Name"),
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.W500,
                fontSize = 18.sp)},
            modifier = Modifier
                .padding(top = 35.dp, bottom = 25.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
                .clip(Shapes.medium)
        )

        TextField(
            value = newPasswordInput,
            onValueChange = { newPasswordInput = it },
            isError = false,
            label = { Text(if(isError)"New Password*" else("New Passowrd"),
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.W500,
                fontSize = 18.sp)} ,
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .padding(bottom = 25.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
                .clip(Shapes.medium),

            // .border(.5.dp, MaterialTheme.colors.primaryVariant, Shapes.medium)
        )
        TextField(
            value = confirmPasswordInput,
            onValueChange = { confirmPasswordInput = it },
            isError =  false,
            label = { Text(if(isError)"Confirm Password*" else("Confirm Password"),
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.W500,
                fontSize = 18.sp)},
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .padding(bottom = 10.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
                .clip(Shapes.medium)
            //.border(.5.dp, MaterialTheme.colors.primaryVariant, Shapes.medium)
        )

        isError = username.isEmpty() or newPasswordInput.isEmpty() or confirmPasswordInput.isEmpty()

        val backgroundColor = Color(0xFF673AB7)
        Button(shape = Shapes.medium,
            colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),
            modifier = Modifier
                .padding(top = 12.dp, bottom = 12.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth(),

            onClick = {
                if (!isError) {
                    viewModel2.forgotPassword(newPasswordInput, confirmPasswordInput)
                    context.startActivity(Intent(context, MainActivity::class.java))
                    Toast.makeText(context, "Password Updated!", Toast.LENGTH_SHORT).show()
                }
                else {
                    Toast.makeText(context, "Error! - Please Enter Your New Password", Toast.LENGTH_SHORT).show()
                }

            }) {

            Text(
                text = "Reset",
                color = Color.White,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.W600,
                fontSize = 20.sp,
                modifier = Modifier.padding(1.dp)
            )
        }
        //Calling CancelButton function
        CancelButton()

    }
}