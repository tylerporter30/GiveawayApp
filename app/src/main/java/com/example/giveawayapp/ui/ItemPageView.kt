package com.example.giveawayapp.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.giveawayapp.network.Donation
import com.example.giveawayapp.viewmodel.DonationViewModel

@Composable
fun ListReusable(
    navController: NavController,
    /*This could be abstracted:*/
    viewModel: DonationViewModel
) {

    DonationList(
        navController = navController,
        donationList = viewModel.donationList,
        onItemClicked = viewModel::itemClicked
    )

}

@Composable
fun DonationList(
    navController: NavController,
    donationList: List<Donation>,
    onItemClicked: (item: Donation) -> Unit
) {
    var listState = rememberLazyListState()
    var donationList =
        LazyColumn(state = listState) {

            itemsIndexed(donationList) { index, item ->
                ItemClickable(
                    donation = donationList[index],
                    onItemClicked
                )
            }
        }
}



