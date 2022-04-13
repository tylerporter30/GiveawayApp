package com.example.giveawayapp.viewmodel

import com.google.gson.annotations.SerializedName

class Auction (

    @SerializedName("id") val id:Int,
    @SerializedName("photo") val photo:Int,
    @SerializedName("item") val item:String,
    @SerializedName("description") val description:String,
    @SerializedName("location") val location:String,
    @SerializedName("condition") val condition:String,
    @SerializedName("type") val type:String
        )