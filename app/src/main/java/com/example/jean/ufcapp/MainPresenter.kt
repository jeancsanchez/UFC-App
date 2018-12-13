package com.example.jean.ufcapp

import com.example.jean.ufcapp.models.Noticia

/**
 * @author Jean Carlos (Github: @jeancsanchez)
 * @date 13/12/18.
 * Jesus is alive!
 */
class MainPresenter {
    var activity: MainActivity? = null
    private val fakeNoticia = Noticia(
            id = 1,
            autor = "Jean",
            titulo = "Lutador quebra pescoço de adversário",
            foto = "http://imagec.ufc.com/http%253A%252F%252Fmedia.ufc.tv%252F1%252F230%252F3GettyImages-1056094360.jpg?mw300-mh300-tc1"
    )

    fun attach(activity: MainActivity) {
        this.activity = activity
    }

    fun carregarNoticias(id: Int? = null) {
        id?.let {
            activity?.mostrarNoticia(fakeNoticia)

        } ?: let {
            val noticias = listOf(
                    fakeNoticia,
                    fakeNoticia.copy(id = 2, titulo = "Quebra pau no palco!", foto = "http://imagec.ufc.com/http%253A%252F%252Fmedia.ufc.tv%252F1%252F230%252F044148_230_WeighIn_ENG_669x376.jpg?mw300-mh300-tc1")
            )
            activity?.mostrarNoticias(noticias)
        }
    }
}