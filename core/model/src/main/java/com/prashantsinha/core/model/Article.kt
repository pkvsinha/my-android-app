package com.prashantsinha.core.model

data class Article(
    val id: Int,
    val title: String,
    val description: String,
    val tldr: String,
    val url: String,
    val publishedAt: String,
)
