package com.prashantsinha.feature.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prashantsinha.core.model.Profile
import com.prashantsinha.core.ui.theme.MyAppTheme

@Composable
fun ProfileScreen(profile: Profile) {
    Column (modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {

        ProfileImage(imageUrl = profile.profileImageUrl)
        Spacer(modifier = Modifier.height(16.dp))

        ProfileName(name = profile.name)
        Spacer(modifier = Modifier.height(4.dp))

        ProfileTitle(title = profile.title)
        Spacer(modifier = Modifier.height(24.dp))

        ProfileBio(bio = profile.bio)
        Spacer(modifier = Modifier.height(24.dp))

        ProfileSkills(skills = profile.skills)
    }
}


@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    // We create a dummy profile object for the preview
    val sampleProfile = Profile(
        name = "Prashant",
        title = "Android Developer | Tech Enthusiast",
        bio = "Welcome to my portfolio! I build beautiful and functional Android apps with Kotlin and Jetpack Compose.",
        profileImageUrl = "https://avatars.githubusercontent.com/u/1024025?v=4", // A placeholder image URL
        skills = listOf("Kotlin", "Jetpack Compose", "Modular Architecture", "Android", "Git")
    )
    MyAppTheme { // Use our shared theme for the preview
        ProfileScreen(profile = sampleProfile)
    }
}