package com.prashantsinha.blog

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.prashantsinha.core.model.ArticleLink
import com.prashantsinha.core.model.Profile
import com.prashantsinha.core.ui.theme.MyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@Composable
fun ArticlesScreen(
    articlesModel: ArticlesViewModel = hiltViewModel<ArticlesViewModel>(),
    onPostClick: (String) -> Unit
) {
    val articlesState by articlesModel.articles.collectAsState()

    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(articlesState) { article ->
            ArticleCard(article = article, onClick = { onPostClick(article.url) })
        }
    }
}

@Composable
fun ArticleCard(article: ArticleLink, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().clickable ( onClick = onClick ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = article.title, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = article.publishedAt, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = article.description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArticlesScreenPreview() {
    // We create a dummy profile object for the preview
    val samplePost = ArticleLink(1, "Sample Title", "This is a short description...", "url", "Jan 1, 2025", )
    MyAppTheme {
        ArticleCard(article = samplePost, onClick = {})
    }
}