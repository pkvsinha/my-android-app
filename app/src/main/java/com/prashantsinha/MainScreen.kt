package com.prashantsinha

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.prashantsinha.navigation.AppBottomNavigation
import com.prashantsinha.navigation.AppNavigation
import com.prashantsinha.navigation.BottomNavItem

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val items = listOf<BottomNavItem>(
        BottomNavItem.Home,
        BottomNavItem.Projects,
        BottomNavItem.Ai,
        BottomNavItem.Articles,
        BottomNavItem.Resume
    )
    val bottomNavVisibility = rememberSaveable { (mutableStateOf(true)) }
    val navBackStackEntry  by navController.currentBackStackEntryAsState()

    bottomNavVisibility.value = when (navBackStackEntry?.destination?.route) {
        "web_view_screen/{url}" -> false
        else -> true
    }

    Scaffold (
        bottomBar = {
            if (bottomNavVisibility.value) {
                AppBottomNavigation(navController, items)
            }
        }
    ) { innerPadding ->
        AppNavigation(navController, Modifier.padding(innerPadding))
    }

}