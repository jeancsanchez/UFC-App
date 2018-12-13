package com.example.jean.ufcapp.data

import com.example.jean.ufcapp.models.Noticia
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author Jean Carlos (Github: @jeancsanchez)
 * @date 13/12/18.
 * Jesus is alive!
 */
interface UFCApi {

    @GET("news")
    fun listarNoticias(): Call<List<Noticia>>

    @GET("news/{id}")
    fun noticiaInfo(@Path("id") id: Long): Call<Noticia>
}