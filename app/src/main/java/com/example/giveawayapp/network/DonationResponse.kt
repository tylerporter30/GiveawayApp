package com.example.giveawayapp.network

import com.example.giveawayapp.network.Donation
import com.google.gson.annotations.SerializedName

data class DonationResponse (

    @SerializedName("Donation List")
    var donationList: List<Donation>

    )