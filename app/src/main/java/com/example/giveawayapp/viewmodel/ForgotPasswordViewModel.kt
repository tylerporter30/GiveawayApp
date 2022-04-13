package com.example.giveawayapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.giveawayapp.network.ForgotPassword
import com.example.giveawayapp.network.repository.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ForgotPasswordViewModel : ViewModel() {

    private val forgotPasswordRequestLiveData = MutableLiveData<Boolean>()

    fun forgotPassword(createNewPassword: String, confirmPassword: String) {

        viewModelScope.launch(Dispatchers.IO) {

            try {

                val authService = RetrofitHelper.getAuthService()

                val responseService =
                    authService.getForgotPassword(ForgotPassword(createNewPassword = createNewPassword, confirmPassword = confirmPassword))

                if (responseService.isSuccessful) {

                    responseService.body()?.let { token ->

                        Log.d("Logging Successful", "Response Token $token")

                    }
                } else {

                    responseService.errorBody()?.let { error ->

                        Log.d("Logging Error", "Response Token $error")

                        error.close()
                    }

                }

                forgotPasswordRequestLiveData.postValue(responseService.isSuccessful)

            } catch (e: Exception) {

                Log.d("Networking Error", "Exception in Networking $e")

            }
        }
    }

    fun successful(): Boolean? {
        return true
    }
}