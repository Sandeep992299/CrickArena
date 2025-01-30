package com.example.crickarina.CommenSection

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.crickarina.Model.NavIterm
import com.example.crickarina.Screen.CartPage
import com.example.crickarina.Screen.MainScreen
import com.example.crickarina.Screen.ProductScreen
import com.example.crickarina.Screen.ProfilePage
import com.example.crickarina.Screen.SignIn
import com.example.crickarina.Screen.SignUpScreen

@Composable
fun BottomNavigationScreen(modifier: Modifier = Modifier) {
    val navItermList = listOf(
        NavIterm("Home", Icons.Default.Home),
        NavIterm("Category", Icons.Default.List),
        NavIterm("Cart", Icons.Default.ShoppingCart),
        NavIterm("Profile", Icons.Default.Person),
    )

    var selectedIndex by remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            // Only show the bottom bar if the selected page is not the Sign In page (selectedIndex != 0)
            if (selectedIndex != 4) {
                NavigationBar {
                    navItermList.forEachIndexed { index, navIterm ->
                        NavigationBarItem(
                            selected = selectedIndex == index,
                            onClick = {
                                selectedIndex = index
                            },
                            icon = {
                                Icon(imageVector = navIterm.icon, contentDescription = "Icon")
                            },
                            label = {
                                Text(text = navIterm.label)
                            }
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        contentScreen(modifier = Modifier.padding(innerPadding), selectedIndex = selectedIndex)
    }
}

@Composable
fun contentScreen(modifier: Modifier = Modifier, selectedIndex: Int) {

    when (selectedIndex) {
        4 -> SignIn()
        0 -> MainScreen()
        1 -> ProductScreen()
        2 -> CartPage()
        3 -> ProfilePage()
        5 -> SignUpScreen()
    }
}
