package com.prashantsinha.core.network

import com.prashantsinha.core.model.ArticleLink
import retrofit2.http.GET

interface ContentService {

    @GET("pkvsinha/8d45a5e36d9939c86b1b7568bd203312/raw/d95d76d20ebb15f4e069a20f6de88ad32598f635/blogs.json")
    suspend fun getPosts(): List<ArticleLink>;
}