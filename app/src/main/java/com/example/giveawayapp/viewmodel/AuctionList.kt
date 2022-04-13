package com.example.giveawayapp.viewmodel


import com.google.gson.annotations.SerializedName
data class AuctionList (

        @SerializedName("auctionList") val auctionList: ArrayList<AuctionList>
    )