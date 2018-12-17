package com.example.jean.ufcapp.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.jean.ufcapp.models.Noticia

/**
 * @author Jean Carlos (Github: @jeancsanchez)
 * @date 17/12/18.
 * Jesus is alive!
 */

@Database(entities = [Noticia::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun noticiaDao(): NoticiaDAO

    companion object {
        private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "noticiasDb"
                ).build()
            }

            return instance!!
        }

        fun destroyInstance() {
            instance = null
        }
    }
}