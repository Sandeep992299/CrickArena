package com.example.crickarina

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.crickarina.CommenSection.BottomNavigationScreen
import com.example.crickarina.Screen.MainScreen
import com.example.crickarina.Screen.SignIn
import com.example.crickarina.ui.theme.CrickArinaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()
            AppNavigation(navController)

            CrickArinaTheme {


                BottomNavigationScreen()



                }

            }

        }

    }
@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "signin") {
        composable("signin") { SignIn(navController) }
        composable("mainscreen") { MainScreen(navController) }
    }
}

