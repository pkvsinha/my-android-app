package com.prashantsinha.blog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prashantsinha.core.model.ArticleLink
import com.prashantsinha.data.ArticleRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel: ViewModel() {

    private val articleRepository = ArticleRepository();

    private val _articles = MutableStateFlow<List<ArticleLink>>(emptyList());
    val articles: StateFlow<List<ArticleLink>> = _articles

    init {
        fetchPosts()
    }

    fun fetchPosts() {
        viewModelScope.launch {
            try {
                _articles.value = articleRepository.getPosts();
            } catch (e: Exception) {
                e.printStackTrace();
            }
        }
    }

}