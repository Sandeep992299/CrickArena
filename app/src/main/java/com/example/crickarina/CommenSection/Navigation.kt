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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.crickarina.Model.NavIterm
import com.example.crickarina.Screen.CartPage
import com.example.crickarina.Screen.MainScreen
import com.example.crickarina.Screen.ProductScreen
import com.example.crickarina.Screen.ProfilePage
import com.example.crickarina.Screen.SignIn
import com.example.crickarina.Screen.SignUpScreen

@Composable
fun BottomNavigationScreen(modifier: Modifier = Modifier) {
    // List of items in the bottom navigation bar
    val navItermList = listOf(
        NavIterm("Home", Icons.Default.Home),
        NavIterm("Category", Icons.Default.List),
        NavIterm("Cart", Icons.Default.ShoppingCart),
        NavIterm("Profile", Icons.Default.Person),
    )

    var selectedIndex by remember {
        mutableIntStateOf(0) // Initialize selected index to 0 (Home)
    }

    // Create a navController for navigation
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            // Only show the bottom bar if the selected page is not the Sign In page (selectedIndex != 4)
            if (selectedIndex != 4) {
                NavigationBar {
                    // For each navigation item, display the NavigationBarItem
                    navItermList.forEachIndexed { index, navIterm ->
                        NavigationBarItem(
                            selected = selectedIndex == index,
                            onClick = {
                                selectedIndex = index // Update the selected index when an item is clicked
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
        // Content based on the selected index, passing the navController for navigation
        contentScreen(
            modifier = Modifier.padding(innerPadding),
            selectedIndex = selectedIndex,
            navController = navController
        )
    }
}

@Composable
fun contentScreen(
    modifier: Modifier = Modifier,
    selectedIndex: Int,
    navController: NavController
) {
    // Display the corresponding screen based on the selected index
    when (selectedIndex) {
        5 -> SignIn(navController)
        0 -> MainScreen(navController)
        1 -> ProductScreen()
        2 -> CartPage()
        3 -> ProfilePage()
        4 -> SignUpScreen()
    }
}
