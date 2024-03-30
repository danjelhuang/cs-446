package com.example.wetravel.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wetravel.R
import com.example.wetravel.components.DestinationEntry
import com.example.wetravel.components.DestinationsListFooter
import com.example.wetravel.components.DestinationsListHeader
import com.example.wetravel.models.Destination


@Preview(showBackground = true)
@Composable
fun UserProfilePreview(
    @PreviewParameter(UserPreviewParameterProvider::class) destination: Destination
) {
    DestinationDetailView(destination)
}

class UserPreviewParameterProvider : PreviewParameterProvider<Destination> {
    override val values = sequenceOf(
        Destination(
            "MoMA", "11 W 53rd St, New York", "4.6", 50,
            R.drawable.sample_destination_image, voted = true, numOfVotes = 5
        ),
    )
}

@Composable
fun DetailContent(destination: Destination, innerPadding: PaddingValues) {
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .padding(horizontal = 16.dp),

        
    ) {
        Text(
            text = destination.name,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 36.sp,
                textAlign = TextAlign.Center,
                color = Color.Black
            )
        )
        Spacer(Modifier.height(10.dp))
        Image(
            painter = painterResource(id = destination.imageResId),
            contentDescription = "${destination.name} image",
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
        )

        Image(
            painter = painterResource(id = destination.imageResId),
            contentDescription = "${destination.name} image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(16.dp))
        )
        Spacer(Modifier.height(16.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.destination_pin),
                contentDescription = "Location pin widget",
                modifier = Modifier.size(16.dp)
            )
            Text(
                text = " ${destination.address}",
                fontSize = 14.sp
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.rating_star),
                contentDescription = "Location pin widget",
                modifier = Modifier.size(16.dp)
            )
            Text(
                text = " ${destination.rating} "
            )
            Text(
                text = "(${destination.reviewCount})",
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun DestinationDetailView(destination: Destination) {
    Scaffold(
        topBar = {
            Image(
                painter = painterResource(id = R.drawable.back_arrow),
                contentDescription = "User icon",
                modifier = Modifier
                    .padding(16.dp)
                    .size(32.dp)
                    .clickable { print("LOL") }

            )
            // Navigate back


        }
    ) { innerPadding ->
        DetailContent(destination = destination, innerPadding = innerPadding)
    }
}