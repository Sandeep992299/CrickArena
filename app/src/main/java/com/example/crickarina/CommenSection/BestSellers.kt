package com.example.crickarina.CommenSection
import android.util.Log.d
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainsCard2(
    imageResourceId: Int,
    title: String,
    price: String,
    backgroundColor: Color = Color.White,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .width(130.dp)
            .height(200.dp)
            .clickable { onClick() }
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(8.dp),
                ambientColor = Color.Black,
                spotColor = Color.Black
            ),
        colors = CardDefaults.cardColors(containerColor = backgroundColor)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(imageResourceId),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(120.dp)
                    .fillMaxWidth()
                    .shadow(
                        elevation = 8.dp,
                        shape = RoundedCornerShape(10.dp),
                        ambientColor = Color.Black,
                        spotColor = Color.Yellow
                    ),
            )
            Text(
                text = title,
                fontSize = 16.sp,
                style = MaterialTheme.typography.labelMedium,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp)
            )
            Text(
                text = "Rs $price",
                fontSize = 16.sp,
                color = Color.Red,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))

        }

    }
}