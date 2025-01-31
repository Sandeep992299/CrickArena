package com.example.crickarina.Screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.primaryContainerDark

@Composable
fun CartPage() {
    // State variable to hold the items in the wishlist
    var wishlistItems by remember { mutableStateOf(listOf<String>()) }

    // Function to clear the wishlist
    fun clearWishlist() {
        wishlistItems = emptyList()
    }

    // Scroll state for the vertical scrolling
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState) // Add vertical scrolling to the column
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(30.dp))

        // Wishlist title centered at the top
        Text(
            text = "Cart",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(50.dp))

        // Enhanced Card with fixed height for prominence
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp) // Increased height for the card
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.LightGray)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize() // Fill the card's size
                    .padding(16.dp),
                contentAlignment = Alignment.Center // Center the content inside the Box
            ) {
                // Check if there are any items in the wishlist
                if (wishlistItems.isEmpty()) {
                    Text(
                        text = "Your Cart is empty",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Black
                    )
                } else {
                    Column {
                        wishlistItems.forEach { item ->
                            Text(
                                text = item,
                                style = MaterialTheme.typography.bodyLarge,
                                modifier = Modifier.padding(vertical = 4.dp)
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)

        ) {

            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Delivery Charge", style = MaterialTheme.typography.bodyLarge)
                Text("Rs.0", style = MaterialTheme.typography.bodyLarge)
            }
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Discount", style = MaterialTheme.typography.bodyLarge)
                Text("Rs.0", style = MaterialTheme.typography.bodyLarge)
            }
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Taxes", style = MaterialTheme.typography.bodyLarge)
                Text("Rs.0", style = MaterialTheme.typography.bodyLarge)
            }
            Spacer(modifier = Modifier.height(36.dp))

            Divider()

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Sub Total",  fontSize = 19.sp, fontWeight = FontWeight.SemiBold)
                Text("Rs.0",  fontSize = 19.sp, fontWeight = FontWeight.SemiBold, color = primaryContainerDark)
            }
            Spacer(modifier = Modifier.height(16.dp))

            Divider()
            Spacer(modifier = Modifier.height(36.dp))


        }

        // Clear button to clear the wishlist
        Button(
            onClick = { clearWishlist() },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.error,   // Set button background color
//                contentColor = Color.White    // Set text color
            )
        ) {
            Text(text = "Clear Cart")
        }

        Spacer(modifier = Modifier.height(90.dp))
    }
}
