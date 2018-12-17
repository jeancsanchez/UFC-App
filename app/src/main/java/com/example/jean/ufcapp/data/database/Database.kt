package com.example.jean.ufcapp.data.database

import android.arch.persistence.room.Room
import android.content.Context

/**
 * @author Jean Carlos (Github: @jeancsanchez)
 * @date 17/12/18.
 * Jesus is alive!
 */
object Database {

    private lateinit var context: Context

    fun init(context: Context) {
        this.context = context
    }

    fun getInstance(): AppDatabase {
        return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "database-name"
        ).build()
    }
}