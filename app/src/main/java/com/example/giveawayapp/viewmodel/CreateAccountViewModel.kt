package com.example.giveawayapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.giveawayapp.network.CreateAccount
import com.example.giveawayapp.network.repository.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class CreateAccountViewModel : ViewModel() {

    private val createAccountRequestLiveData = MutableLiveData<Boolean>()

    fun createAccount(
        fullName: String,
        username: String,
        email: String,
        address: String,
        city: String,
        state: String,
        zipCode: String,
        accountPassword: String,
        accountConfirmPassword: String
    ) {

        viewModelScope.launch(Dispatchers.IO) {

            try {

                val authService = RetrofitHelper.getAuthService()

                val responseService =
                    authService.getCreateAccount(
                        CreateAccount(
                            fullName = fullName,
                            username = username,
                            email = email,
                            address = address,
                            city = city,
                            state = state,
                            zipCode = zipCode,
                            password = accountPassword,
                            confirmPassword = accountConfirmPassword
                        )
                    )

                if (responseService.isSuccessful) {

                    responseService.body()?.let { getResponseCreateAccount ->

                        Log.d("Logging Successful", "Response Token $getResponseCreateAccount")

                    }
                } else {

                    responseService.errorBody()?.let { error ->

                        Log.d("Logging Error", "Response Token $error")

                        error.close()
                    }

                }

                createAccountRequestLiveData.postValue(responseService.isSuccessful)

            } catch (e: Exception) {

                Log.d("Networking Error", "Exception in Networking $e")

            }
        }
    }

    fun successful(): Boolean? {
        return true
    }
}

