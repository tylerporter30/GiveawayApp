package com.example.giveawayapp.network.repository

import com.example.giveawayapp.R
import com.example.giveawayapp.network.Donation

object DummyDonation {
    val dummy = Donation(
        id = 0,
        donationName = "2003 Mercedes Benz",
        publisher = "John Adams",
        location = "Paris, France",
        time = "03/27/2022, 9:34",
        description = "Black 2003 Mercedes Benz in good condition. Needs gas, and a new steering wheel",
        tags = listOf<String>(" Vehicle,", " Driving,", " Travel"),//needs conversion
        images = listOf<Int>(R.drawable.mercedes, R.drawable.mercedes1, R.drawable.mercedes2, R.drawable.mercedes4)//Kotlin will print the name of the data and not the data
    )
    val dummy1 = Donation(
        id = 1,
        donationName = "Xbox 360",
        publisher = "Abraham Lincoln",
        location = "Winchester, CA",
        time = "07/02/2021, 11:24",
        description = "Xbox 360 in average condition. Needs controller, and a hard drive.",
        tags = listOf<String>(" Gaming,", " Xbox,", " Console"),//needs conversion
        images = listOf<Int>(R.drawable.xbox, R.drawable.xbox1, R.drawable.xbox2, R.drawable.xbox3)//Kotlin will print the name of the data and not the data
    )
    val dummy2 = Donation(
        id = 2,
        donationName = "IPhone 13",
        publisher = "John Adams",
        location = "Paris, France",
        time = "07/04/2021, 10:47",
        description = "IPhone 13 with Charger. Needs a new camera and home button, but works fine.",
        tags = listOf<String>(" Phone,", " IPhone 13,", " Call,", " Camera"),//needs conversion
        images = listOf<Int>(R.drawable.iphone, R.drawable.iphone1, R.drawable.iphone2, R.drawable.iphone3)//Kotlin will print the name of the data and not the data
    )
    val dummyList:List<Donation> = listOf(dummy, dummy1, dummy2)
}