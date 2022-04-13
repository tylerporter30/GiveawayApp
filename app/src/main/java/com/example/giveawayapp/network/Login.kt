package com.example.giveawayapp.network

import com.google.gson.annotations.SerializedName

data class Login(

    @SerializedName("username") val username: String,

    @SerializedName("password") val password: String
)
