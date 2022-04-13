package com.example.giveawayapp.network

import com.google.gson.annotations.SerializedName

data class token(

    @SerializedName("auth_token") val auth_token: String,
    @SerializedName("success_msg") val success_msg: String,
    //@SerializedName("failure_msg") val failure_msg: String
)
