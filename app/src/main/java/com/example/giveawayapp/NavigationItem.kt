package com.example.giveawayapp

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home : NavigationItem("home", R.drawable.ic_home, "Home")
    object Social : NavigationItem("social", R.drawable.ic_social, "Social")
    object Profile : NavigationItem("profile", R.drawable.ic_profile, "Profile")
}
