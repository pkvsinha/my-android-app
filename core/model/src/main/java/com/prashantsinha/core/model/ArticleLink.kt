package com.prashantsinha.core.model

import kotlinx.serialization.Serializable

@Serializable
data class ArticleLink(
    val id: Int,
    val title: String,
    val description: String,
    val url: String,
    val publishedAt: String,
)
