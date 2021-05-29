package com.example.workers.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [UserRoom::class,
        SpecialtyRoom::class], version = 1
)
abstract class databaseWorkers : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun specDao(): SpecialtyDao
}