package com.example.workers.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Query("SELECT * FROM userroom")
    suspend fun getAllUsers(): List<UserRoom>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserRoom)

    @Query("SELECT EXISTS(SELECT * FROM userroom WHERE l_name = :l_name AND f_name = :f_name)")
    suspend fun isUsers(l_name: String, f_name: String): Boolean

    @Query("DELETE FROM userroom")
    fun clearUsers()

//    @Query("SELECT * FROM userroom WHERE specialtyList IN (:id)")
//    suspend fun getUsersWitchSpecialty(id: Int): List<UserRoom>

}