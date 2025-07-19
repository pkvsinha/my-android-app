package com.prashantsinha.core.ui.android

import android.os.Bundle
import android.os.PersistableBundle
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.prashantsinha.core.ui.theme.MyAppTheme
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

class WebViewActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyAppTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val url = intent.getStringExtra("url") ?: "https://prashantsinha.com"
                    val decodedUrl = URLDecoder.decode(url, StandardCharsets.UTF_8.toString())
                    AndroidView(
                        modifier = Modifier
                            .windowInsetsPadding(WindowInsets.statusBars)
                            .fillMaxSize(),
                        factory = { context ->
                            WebView(context).apply {
                                layoutParams = ViewGroup.LayoutParams(
                                    ViewGroup.LayoutParams.MATCH_PARENT,
                                    ViewGroup.LayoutParams.MATCH_PARENT
                                )
                                webViewClient = WebViewClient()
                                settings.javaScriptEnabled = true
                                loadUrl(decodedUrl)
                            }
                        }
                    )
                }
            }
        }
    }
}