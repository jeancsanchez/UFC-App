package com.example.jean.ufcapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.jean.ufcapp.models.Noticia

class MainActivity : AppCompatActivity() {

    private val presenter by lazy { MainPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.attach(this)
        presenter.carregarNoticias()
    }


    fun mostrarNoticias(list: List<Noticia>) {

    }

    fun mostrarNoticia(noticia: Noticia) {

    }
}
