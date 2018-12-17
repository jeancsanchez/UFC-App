package com.example.jean.ufcapp.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * @author Jean Carlos (Github: @jeancsanchez)
 * @date 13/12/18.
 * Jesus is alive!
 */

@Entity
data class Noticia(

        @PrimaryKey
        val id: Long,

        @SerializedName("author")
        val autor: String,

        @SerializedName("title")
        val titulo: String,

        @SerializedName("thumbnail")
        val foto: String? = null
)