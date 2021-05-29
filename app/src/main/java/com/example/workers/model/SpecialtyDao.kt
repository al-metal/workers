package com.example.workers.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SpecialtyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSpec(specRoom: SpecialtyRoom)

    @Query("SELECT * FROM SpecialtyRoom")
    suspend fun getAllSpec(): List<SpecialtyRoom>
}