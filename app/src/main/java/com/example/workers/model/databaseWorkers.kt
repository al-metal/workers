package com.example.workers.model

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [UserRoom::class,
        SpecialtyRoom::class], version = 1
)
@TypeConverters(SpecialtyConverter::class)
abstract class databaseWorkers : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun specDao(): SpecialtyDao
}