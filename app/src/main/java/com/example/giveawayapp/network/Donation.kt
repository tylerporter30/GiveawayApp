package com.example.giveawayapp.network

import com.google.gson.annotations.SerializedName

data class Donation(

    @SerializedName("id")
    val id: Int,

    @SerializedName("publisher")
    val publisher: String,

    @SerializedName("donation")
    val donationName: String,

    @SerializedName("location")
    val location: String,

    @SerializedName("time")
    val time: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("tags")
    val tags: List<String>,

    @SerializedName("images")
    val images: List<Int>
    )