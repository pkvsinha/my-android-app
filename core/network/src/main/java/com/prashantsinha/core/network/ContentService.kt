package com.prashantsinha.core.network

import com.prashantsinha.core.model.ArticleLink
import retrofit2.http.GET

interface ContentService {

    @GET("pkvsinha/8d45a5e36d9939c86b1b7568bd203312/raw/f78aa3367692c03925f300f9aff88215bbd84bb0/blogs.json")
    suspend fun getPosts(): List<ArticleLink>;
}