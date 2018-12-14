package com.example.jean.ufcapp.noticiadetalhe

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.jean.ufcapp.R
import kotlinx.android.synthetic.main.activity_detalhe.*

class DetalheActivity : AppCompatActivity() {

    lateinit var url: String

    companion object {
        const val NOTICIA_EXTRA = "NOTICIA EXTRA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        url = intent.extras.getString(NOTICIA_EXTRA)

        webviewNoticia.settings.javaScriptEnabled = true
        webviewNoticia.settings.useWideViewPort = true
        webviewNoticia.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                progressDetalhe.visibility = View.GONE
            }
        }

        webviewNoticia.loadUrl(url)
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        finish()
        return true
    }
}
