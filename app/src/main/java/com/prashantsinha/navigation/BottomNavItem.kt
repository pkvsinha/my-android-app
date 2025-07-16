package com.prashantsinha.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable

sealed class BottomNavItem(val route: String, val icon: ImageVector, val label: String) {

    object Home : BottomNavItem("home", Icons.Default.Home, "Home")

    object Projects : BottomNavItem("projects", Icons.Default.Build, "Projects")

    object Articles : BottomNavItem("articles", Icons.Default.Email, "Articles")

    object Resume : BottomNavItem("resume", Icons.Default.AccountBox, "Resume")
}