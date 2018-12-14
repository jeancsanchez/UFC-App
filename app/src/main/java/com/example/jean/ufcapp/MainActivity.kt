package com.example.jean.ufcapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.example.jean.ufcapp.models.Noticia
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
        noticiaAdapter.adicionarNoticias(list)
    }

    fun mostrarNoticia(noticia: Noticia) {

    }

    fun mostrarLoading() {
        swipeNews.isRefreshing = true
    }

    fun esconderLoading() {
        swipeNews.isRefreshing = false
    }
}
