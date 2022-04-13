package com.example.giveawayapp.network

import retrofit2.http.GET

interface ApiInterface {

    @GET("donations/")
    suspend fun getDonations(): DonationResponse

}