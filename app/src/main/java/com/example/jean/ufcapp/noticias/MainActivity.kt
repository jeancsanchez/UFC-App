package com.example.jean.ufcapp.noticias

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.example.jean.ufcapp.R
import com.example.jean.ufcapp.models.Noticia
import com.example.jean.ufcapp.noticiadetalhe.DetalheActivity
import com.example.jean.ufcapp.noticiadetalhe.DetalheActivity.Companion.NOTICIA_EXTRA
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val presenter by lazy { MainPresenter() }
    private val noticiaAdapter by lazy { NoticiaAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recviewNews.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        recviewNews.adapter = noticiaAdapter
        swipeNews.setColorSchemeColors(
                resources.getColor(R.color.colorPrimaryDark),
                resources.getColor(R.color.colorAccent)
        )
        swipeNews.setOnRefreshListener { presenter.carregarNoticias() }

        presenter.attach(this)
        presenter.carregarNoticias()
    }


    fun mostrarNoticias(list: List<Noticia>) {
        noticiaAdapter.adicionarNoticias(list) { presenter.carregarNoticias(id = it) }
    }

    fun mostrarNoticia(url: String) {
        val intent = Intent(this, DetalheActivity::class.java)
        intent.putExtra(NOTICIA_EXTRA, url)
        startActivity(intent)
    }

    fun mostrarLoading() {
        swipeNews.isRefreshing = true
    }

    fun esconderLoading() {
        swipeNews.isRefreshing = false
    }
}
