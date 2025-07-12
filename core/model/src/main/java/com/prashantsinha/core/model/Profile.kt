package com.prashantsinha.core.model

data class Profile(
    val name: String,
    val title: String,
    val bio: String,
    val profileImageUrl: String, // We'll use a URL for the image
    val skills: List<String>
)
