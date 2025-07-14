package com.prashantsinha.data

import com.prashantsinha.core.model.ArticleLink
import com.prashantsinha.core.network.di.NetworkModule

class ArticleRepository {

    suspend fun getPosts(): List<ArticleLink> {
        return NetworkModule().contentService().getPosts();
    }
}