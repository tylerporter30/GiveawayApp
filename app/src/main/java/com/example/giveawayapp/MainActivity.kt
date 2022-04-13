package com.example.giveawayapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.giveawayapp.ui.LoginText
import com.example.giveawayapp.ui.LoginView
import com.example.giveawayapp.ui.theme.GiveawayAppTheme
import com.example.giveawayapp.viewmodel.LoginViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GiveawayAppTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {

                    LoginText(displayText = "New To You")

                    LoginView(viewModel = viewModel)
                }
            }
        }
    }
}


