package com.example.jean.ufcapp.noticias

import com.example.jean.ufcapp.data.Remote
import com.example.jean.ufcapp.models.Noticia
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

        id?.let {
            activity?.mostrarNoticia(Remote.ENDPOINT.plus("news/$id"))
            activity?.esconderLoading()

        } ?: Remote.getService().listarNoticias().enqueue(object : Callback<List<Noticia>> {
            override fun onResponse(call: Call<List<Noticia>>, response: Response<List<Noticia>>) {
                response.body()?.let { activity?.mostrarNoticias(it) }
                        ?: onFailure(call, Throwable())
                activity?.esconderLoading()
            }

            override fun onFailure(call: Call<List<Noticia>>, t: Throwable) {
                // TODO: Activity?.mostrarErro()
                t.printStackTrace()
                activity?.esconderLoading()
            }
        })
    }
}