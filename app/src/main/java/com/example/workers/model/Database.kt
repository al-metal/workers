package com.example.workers.model

import android.content.Context
import androidx.room.Room

object Database {

    lateinit var instance: databaseWorkers
        private set

    fun init(context: Context) {
        instance = Room.databaseBuilder(context, databaseWorkers::class.java, "workers").build()
    }
}