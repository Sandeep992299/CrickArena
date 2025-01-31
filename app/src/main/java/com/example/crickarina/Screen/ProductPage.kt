package com.example.crickarina.Screen



import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.crickarina.CommenSection.MainsCard
import com.example.crickarina.CommenSection.MainsCard2
import com.example.crickarina.Data.BestSeller22
import com.example.crickarina.Data.QuickNavigationIterm
import com.example.crickarina.Model.BestSeller2
import com.example.crickarina.Model.Quicknavigation2
import com.example.crickarina.R


@Composable
fun ProductScreen() {
    val searchQuery = remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color.Yellow,
                                fontWeight = FontWeight.Bold,
                                fontSize = 34.sp
                            )
                        ) {
                            append("Crick ")
                        }
                        withStyle(
                            style = SpanStyle(
                                color = Color.Blue,
                                fontWeight = FontWeight.Bold,
                                fontSize = 34.sp
                            )
                        ) {
                            append("Arena")
                        }
                    }
                )

                IconButton(
                    onClick = { /* Handle view cart logic */ },
                    modifier = Modifier.size(36.dp)
                ) {
                    Icon(Icons.Filled.Person, contentDescription = "View Cart")
                }
            }

            Text(
                text = "Categories",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                ),
                modifier = Modifier
                    .padding(15.dp)
                    .align(Alignment.Start)

            )




            CategoryBar()

            Spacer(modifier = Modifier.height(10.dp))




            BestSellerList(BestIterms = BestSeller22().loadBestNavigationIterm())
            Spacer(modifier = Modifier.height(10.dp))



            Text(
                text = "Bats",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp // Set the desired font size here
                ),
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .align(Alignment.Start)

            )
            BestSellerList(BestIterms = BestSeller22().loadBestNavigationIterm())
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Balls",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp // Set the desired font size here
                ),
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .align(Alignment.Start)

            )
            FooditemsList(foodList = QuickNavigationIterm().loadQuickNavigationIterm())
            Spacer(modifier = Modifier.height(100.dp))
        }


    }


}





//creating  the categoryChip
@Composable
fun CategoryChip1(
    titleRes : Int,
    imageRes: Int,
    isSelect: Boolean,
    onSelected: () -> Unit,
    modifier: Modifier = Modifier
){
    val backgroundColor by animateColorAsState(
        targetValue = if (isSelect) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant,
        label = "Category Background"
    )
    val textColor by animateColorAsState(
        targetValue = if (isSelect) Color.Yellow else Color.Black,
        label = "Category Text Color"
    )
    val fontWeight = if (isSelect) FontWeight.Bold else FontWeight.Normal

    Column(
        modifier = Modifier.clickable{ onSelected() },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .shadow(elevation = 6.dp, ambientColor = MaterialTheme.colorScheme.onBackground)
                .background(backgroundColor),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = stringResource(id = titleRes),
                modifier = Modifier.size(72.dp),
                contentScale = ContentScale.Fit
            )
        }
        Text(
            text = stringResource(id = titleRes),
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = fontWeight,
            fontSize = 16.sp,

            )
    }
}