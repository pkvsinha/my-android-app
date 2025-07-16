package com.prashantsinha.navigation

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.prashantsinha.blog.ArticlesScreen
import com.prashantsinha.core.model.Profile
import com.prashantsinha.feature.profile.ProfileScreen
import com.prashantsinha.features.ai.AiHomeScreen
import com.prashantsinha.home.HomeScreen
import com.prashantsinha.projects.ProjectsScreen

@Composable
fun AppNavigation(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController, startDestination = BottomNavItem.Home.route, modifier = modifier) {
        composable(BottomNavItem.Home.route) {
            HomeScreen()
        }
        composable(BottomNavItem.Projects.route) {
            ProjectsScreen()
        }
        composable(BottomNavItem.Ai.route) {
            AiHomeScreen()
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