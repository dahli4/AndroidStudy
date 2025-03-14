package com.example.part2.chapter01

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.part2.chapter01.databinding.FragmentWebbiewBinding

class WebViewFragment : Fragment() {
    private lateinit var binding: FragmentWebbiewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWebbiewBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.webView.loadUrl("https://www.google.com")
        binding.webView.webViewClient = WebtoonWebViewClient(binding.progressBar)
        binding.webView.settings.javaScriptEnabled = true
    }
}