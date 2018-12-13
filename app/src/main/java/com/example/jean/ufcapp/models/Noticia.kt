package com.example.jean.ufcapp.models

import com.google.gson.annotations.SerializedName

/**
 * @author Jean Carlos (Github: @jeancsanchez)
 * @date 13/12/18.
 * Jesus is alive!
 */
data class Noticia(

        val id: Long,

        @SerializedName("author")
        val autor: String,

        @SerializedName("title")
        val titulo: String,

        @SerializedName("thumbnail")
        val foto: String? = null
)