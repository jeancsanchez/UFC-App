package com.example.jean.ufcapp.noticias

import com.example.jean.ufcapp.data.Remote
import com.example.jean.ufcapp.data.database.AppDatabase
import com.example.jean.ufcapp.models.Noticia
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * @author Jean Carlos (Github: @jeancsanchez)
 * @date 13/12/18.
 * Jesus is alive!
 */
class MainPresenter {
    var activity: MainActivity? = null

    fun attach(activity: MainActivity) {
        this.activity = activity
    }

    fun carregarNoticias(id: Long? = null) {
        activity?.mostrarLoading()

        activity?.let {
            if (id != null) {
                it.mostrarNoticia(Remote.ENDPOINT.plus("news/$id"))
                it.esconderLoading()
            } else {
                val noticias = runBlocking {
                    GlobalScope.async {
                        AppDatabase.getDatabase(it)
                                .noticiaDao()
                                .buscarTodas()
                    }.await()
                }

                if (noticias.isEmpty().not()) {
                    it.mostrarNoticias(noticias)
                    it.esconderLoading()
                } else {
                    Remote
                            .getService()
                            .listarNoticias()
                            .enqueue(object : Callback<List<Noticia>> {
                                override fun onResponse(call: Call<List<Noticia>>, response: Response<List<Noticia>>) {
                                    response.body()?.let { noticias ->
                                        it.mostrarNoticias(noticias)

                                        GlobalScope.launch {
                                            AppDatabase
                                                    .getDatabase(it)
                                                    .noticiaDao()
                                                    .inserir(noticias)
                                        }

                                    } ?: onFailure(call, Throwable())
                                    it.esconderLoading()
                                }

                                override fun onFailure(call: Call<List<Noticia>>, t: Throwable) {
                                    // TODO: Activity?.mostrarErro()
                                    t.printStackTrace()
                                    activity?.esconderLoading()
                                }
                            })
                }
            }
        }
    }


    fun onDestroy() {
        activity?.let { AppDatabase.destroyInstance() }
        activity = null
    }
}