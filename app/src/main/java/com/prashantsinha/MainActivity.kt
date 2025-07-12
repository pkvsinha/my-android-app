package com.prashantsinha

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.prashantsinha.core.model.Profile
import com.prashantsinha.core.ui.theme.MyAppTheme
import com.prashantsinha.feature.profile.ProfileScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    // Create some sample data for now
                    val myProfile = Profile(
                        name = "Prashant Sinha",
                        title = "Android Developer | Tech Enthusiast",
                        bio = "Welcome to my portfolio! I build beautiful and functional Android apps with Kotlin and Jetpack Compose.",
                        // Replace with a real image URL!
                        profileImageUrl = "https://avatars.githubusercontent.com/u/1024025?v=4", // Example: Google's GitHub avatar
                        skills = listOf("Kotlin", "Jetpack Compose", "Modular Architecture", "Android", "Git", "Coroutines")
                    )
                    ProfileScreen(profile= myProfile)
                }
            }
        }
    }
}