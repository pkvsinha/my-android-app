package com.prashantsinha.feature.profile

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ProfileBio(bio: String) {
    Text(
        text = bio,
        style = MaterialTheme.typography.bodyMedium,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(horizontal = 16.dp)
    )
}