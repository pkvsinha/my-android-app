package com.prashantsinha

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import com.prashantsinha.core.ui.theme.MyAppTheme
import com.prashantsinha.feature.profile.ProfileScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppTheme {
                // navigation setup
                val navController = rememberNavController()
                val navs = listOf("profile" to Icons.Default.Face, "blog" to Icons.Default.List)

                Scaffold(
                    bottomBar = {
                        NavigationBar {
                            val navBackStack = navController.currentBackStackEntryAsState().value
                            val currentDestination = navBackStack?.destination
                            navs.forEach { (screen, icon) ->
                                NavigationBarItem(
                                    icon = { Icon(icon, contentDescription = null) },
                                    label = { Text(screen.replaceFirstChar { it.uppercase() }) },
                                    selected = currentDestination?.hierarchy?.any { it.route == screen } == true,
                                    onClick = {
                                        navController.navigate(screen) {
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
                    NavHost(navController, startDestination = "profile", Modifier.padding(innerPadding)) {
                        composable("profile") {
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
                        composable("blog") {
                            val context = LocalContext.current
                            ArticlesScreen( onPostClick =  {
                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
                                context.startActivity(intent)
                            } )
                        }
                    }
                }
            }
        }
    }
}