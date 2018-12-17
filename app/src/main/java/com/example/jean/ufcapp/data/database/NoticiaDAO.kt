package com.example.jean.ufcapp.data.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.jean.ufcapp.models.Noticia

/**
 *
 * @author Jean Carlos (Github: @jeancsanchez)
 * @date 17/12/18.
 * Jesus is alive!
 */
@Dao
interface NoticiaDAO {

    @Query("SELECT * FROM noticia")
    fun buscarTodas(): List<Noticia>

    @Insert
    fun inserir(noticias: List<Noticia>)
}
