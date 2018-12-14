package com.example.jean.ufcapp.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author Jean Carlos (Github: @jeancsanchez)
 * @date 13/12/18.
 * Jesus is alive!
 */
object Remote {

    const val ENDPOINT = "http://ufc-data-api.ufc.com/api/v2/us/"


    fun getService(): UFCApi {
        val retrofit = Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        return retrofit.create(UFCApi::class.java)
    }
}