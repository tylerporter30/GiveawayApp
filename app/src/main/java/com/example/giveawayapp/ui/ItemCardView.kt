package com.example.giveawayapp.ui

import android.content.Intent
import android.widget.Toast
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.giveawayapp.DonationRequest
import com.example.giveawayapp.R
import com.example.giveawayapp.network.Donation
import com.example.giveawayapp.network.repository.DummyDonation
import com.example.giveawayapp.ui.theme.purpleLight


@Composable
fun ItemClickable(
    donation: Donation,
    onItemClicked: (item: Donation) -> Unit
) {

    ItemCard(donation = donation,
        modifier = Modifier
            .padding(8.dp)
            .clickable { //TODO connect to navController
//            onItemClicked(donation)
//            navController.navigate("")
            })
}

//@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ItemCard(
    donation: Donation, modifier: Modifier = Modifier
        .padding(8.dp)
        .clickable { //TODO connect to navController
        }
) {
    // We keep track if the message is expanded or not in this
    var isExpanded by remember { mutableStateOf(false) }
    // surfaceColor will be updated gradually from one color to the other
    val surfaceColor: Color by animateColorAsState(
        if (isExpanded) MaterialTheme.colors.surface else MaterialTheme.colors.primaryVariant,
    )

    Card(
        elevation = 10.dp,
        modifier = Modifier.padding(10.dp),
        backgroundColor = purpleLight,
        border = BorderStroke(1.dp, MaterialTheme.colors.primaryVariant)
    ) {
        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            LazyRow {
                items(donation.images.size) { index ->
                    Image(
                        painter = painterResource(id = donation.images[index]),
                        contentDescription = null,
                        modifier = Modifier
                            .size(250.dp)
                            .padding(8.dp),
                        contentScale = ContentScale.Fit
                    )
                }
            }

            Divider()
            Text(
                text = "Item Name: " + donation.donationName,
                modifier = Modifier.padding(all = 4.dp),
                // If the message is expanded, we display all its content
                // otherwise we only display the first line
                maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.W500,
                fontSize = 20.sp,
            )
            Text(
                text = "Description: " + donation.description,
                modifier = Modifier.padding(all = 4.dp),
                // If the message is expanded, we display all its content
                // otherwise we only display the first line
                maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.W500,
                fontSize = 15.sp,
            )
            Text(
                text = "Location: " + donation.location,
                modifier = Modifier.padding(all = 4.dp),
                // If the message is expanded, we display all its content
                // otherwise we only display the first line
                maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.W500,
                fontSize = 15.sp,
            )
            Text(
                text = "Time Posted: " + donation.time,
                modifier = Modifier.padding(all = 4.dp),
                // If the message is expanded, we display all its content
                // otherwise we only display the first line
                maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.W500,
                fontSize = 15.sp,
            )
            Text(text = " Tags: ")
            LazyRow {
                items(donation.tags.size) { index ->
                    Text(
                        text = donation.tags[index],
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.W500,
                        fontSize = 15.sp,
                    )
                }
            }
            Text(
                text = "Published By: " + donation.publisher,
                modifier = Modifier.padding(all = 4.dp),
                // If the message is expanded, we display all its content
                // otherwise we only display the first line
                maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.W500,
                fontSize = 15.sp,
            )
            Row(modifier = Modifier.padding(all = 8.dp)) {
                Image(
                    painter = painterResource(R.drawable.logo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .border(1.dp, MaterialTheme.colors.primary, CircleShape)
                        .background(color = Color.White)
                )
                Spacer(modifier = Modifier.width(8.dp))
            }

            Divider(modifier = Modifier, color = Color.LightGray)
            val context = LocalContext.current
            TextButton(onClick = {
                context.startActivity(Intent(context, DonationRequest::class.java))
                Toast.makeText(context, "Requesting Item....", Toast.LENGTH_SHORT).show()

            }) {
                Text(
                    text = "Request Item",
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.W500,
                    fontSize = 15.sp,
                    color = Color(0xFF673AB7)
                )
            }
        }
    }
}

@Composable
@Preview
fun ItemListPreview() {
    ItemCard(donation = DummyDonation.dummy)
}