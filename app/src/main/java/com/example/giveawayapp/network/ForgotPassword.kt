package com.example.giveawayapp.network

import com.google.gson.annotations.SerializedName

data class ForgotPassword(

    @SerializedName("createNewPassword") val createNewPassword: String,
    @SerializedName("confirmPassword") val confirmPassword: String,
)
