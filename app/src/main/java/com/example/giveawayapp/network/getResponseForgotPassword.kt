package com.example.giveawayapp.network

import com.google.gson.annotations.SerializedName

data class getResponseForgotPassword (

    @SerializedName("success_msg_forgot_password") val success_msg_forgot_password: String
)
