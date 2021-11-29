package com.ramsay.moviedetails.view

import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.ramsay.moviedetails.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebViewBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            webView.loadUrl("https://in.bookmyshow.com/explore/movies")
            webView.settings.javaScriptEnabled = true

            webView.webViewClient = WebViewClient()

        }


    }
}