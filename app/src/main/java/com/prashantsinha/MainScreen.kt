package com.prashantsinha

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.prashantsinha.navigation.AppNavigation
import com.prashantsinha.navigation.BottomNavItem

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val items = listOf<BottomNavItem>(
        BottomNavItem.Home,
        BottomNavItem.Projects,
        BottomNavItem.Articles,
        BottomNavItem.Resume
    )

    Scaffold (
        bottomBar = {
            NavigationBar {
                val navBackStack = navController.currentBackStackEntryAsState().value
                val currentDestination = navBackStack?.destination
                items.forEach { screen ->
                    NavigationBarItem(
                        icon = { Icon(screen.icon, contentDescription = screen.label) },
                        label = { Text(screen.label) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        AppNavigation(navController, Modifier.padding(innerPadding))
    }

}