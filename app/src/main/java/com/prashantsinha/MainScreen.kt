package com.prashantsinha

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.prashantsinha.blog.ArticlesScreen
import com.prashantsinha.core.model.Profile
import com.prashantsinha.feature.profile.ProfileScreen
import com.prashantsinha.home.HomeScreen
import com.prashantsinha.navigation.BottomNavItem
import com.prashantsinha.projects.ProjectsScreen

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navs = listOf<BottomNavItem>(
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
                navs.forEach { screen ->
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
        NavHost(navController, startDestination = BottomNavItem.Home.route, Modifier.padding(innerPadding)) {
            composable(BottomNavItem.Home.route) {
                HomeScreen()
            }
            composable(BottomNavItem.Projects.route) {
                ProjectsScreen()
            }
            composable(BottomNavItem.Articles.route) {
                val context = LocalContext.current
                ArticlesScreen (onPostClick = { url ->
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    context.startActivity(intent)
                })
            }
            composable(BottomNavItem.Resume.route) {
                // You can get your profile data from a ViewModel later
                val myProfile = Profile(
                    name = "Prashant Sinha",
                    title = "Android Developer | Tech Enthusiast",
                    bio = "Welcome to my portfolio! I build beautiful and functional Android apps with Kotlin and Jetpack Compose.",
                    // Replace with a real image URL!
                    profileImageUrl = "https://avatars.githubusercontent.com/u/1024025?v=4", // Example: Google's GitHub avatar
                    skills = listOf("Kotlin", "Jetpack Compose", "Modular Architecture", "Android", "Git", "Coroutines")
                )
                ProfileScreen(profile = myProfile)
            }
        }
    }

}