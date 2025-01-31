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
import androidx.compose.runtime.LaunchedEffect
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
import androidx.navigation.NavController
import com.example.crickarina.CommenSection.MainsCard
import com.example.crickarina.CommenSection.MainsCard2
import com.example.crickarina.Data.BestSeller22
import com.example.crickarina.Data.QuickNavigationIterm
import com.example.crickarina.Model.BestSeller2
import com.example.crickarina.Model.Quicknavigation2
import com.example.crickarina.R
import kotlinx.coroutines.delay


@Composable
fun MainScreen(navController: NavController) {
    val searchQuery = remember { mutableStateOf("") }
    val scrollState = rememberScrollState()
    val bannerImages = listOf(R.drawable.promo1, R.drawable.promo2)
    var currentBannerIndex by remember { mutableStateOf(0) }
    val bestSellers = BestSeller22().loadBestNavigationIterm()

    LaunchedEffect(Unit) {
        while (true) {
            delay(3000)
            currentBannerIndex = (currentBannerIndex + 1) % bannerImages.size
        }
    }

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

            // Search Box Section
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 22.dp)
            ) {
                OutlinedTextField(
                    value = searchQuery.value,
                    onValueChange = { searchQuery.value = it },
                    label = { Text("Search") },
                    leadingIcon = {
                        Icon(Icons.Filled.Search, contentDescription = "Search Icon")
                    },
                    shape = RoundedCornerShape(26.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Center)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))



                    CategoryBar()

            Spacer(modifier = Modifier.height(10.dp))


            Spacer(modifier = Modifier.height(10.dp))



//


            // Banner Section
            Image(
                painter = painterResource(bannerImages[currentBannerIndex]),
                contentDescription = "Banner",
                modifier = Modifier.fillMaxWidth().height(400.dp).clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )

            // Best Sellers Section
            Text(
                text = "Best Sellers",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                ),
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .align(Alignment.Start)
            )


BestSellerList(BestIterms = BestSeller22().loadBestNavigationIterm())
            Spacer(modifier = Modifier.height(10.dp))
//


            Text(
                text = "Kookaburra",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                ),
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .align(Alignment.Start)

            )
            BestSellerList(BestIterms = BestSeller22().loadBestNavigationIterm())
            Spacer(modifier = Modifier.height(100.dp))

        }


    }


}





@Composable
fun CoffeIterm(foodPictures: Quicknavigation2, modifier: Modifier) {
    MainsCard(
        imageResourceId = foodPictures.imageResId,
        title = stringResource(id = foodPictures.name),
        price = stringResource(id = foodPictures.price),
        backgroundColor = Color.White
    )
}

@Composable
fun FooditemsList(foodList: List<Quicknavigation2>) {
    val limitedFooditem = foodList.take(5)
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(limitedFooditem) { fooditem ->
            CoffeIterm(foodPictures = fooditem, modifier = Modifier.padding(9.dp))
        }
    }
}


@Composable
fun BestIterm(foodPictures: BestSeller2, modifier: Modifier) {
    MainsCard2(
        imageResourceId = foodPictures.imageResId,
        title = stringResource(id = foodPictures.name),
        price = stringResource(id = foodPictures.price),
        backgroundColor = Color.White
    )
}



@Composable
fun BestSellerList(BestIterms: List<BestSeller2>) {
    val limitedFooditem = BestIterms.take(5)
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(limitedFooditem) { fooditem ->
            BestIterm(foodPictures = fooditem, modifier = Modifier.padding(9.dp))
        }
    }
}








// creating a Category bar
@Composable
fun CategoryBar(
    modifier: Modifier = Modifier,
    categories: List<Quicknavigation2> = QuickNavigationIterm().loadQuickNavigationIterm()
) {
    var selectedCategory by remember { mutableStateOf(0) }

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.Start),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(categories.size) { index ->
            val category = categories[index]
            CategoryChip(
                titleRes = category.name,
                imageRes = category.imageResId,
                isSelect = selectedCategory == index,
                onSelected = { selectedCategory = index },
            )
        }
    }
}

//creating  the categoryChip
@Composable
fun CategoryChip(
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