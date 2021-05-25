package com.example.workers.model

import androidx.room.Entity
import androidx.room.PrimaryKey

data class SpecialtyFull(
    var specialty_id: Int? = null,
    var name: String? = null,
    var userList: MutableList<User>? = mutableListOf()
)

@Entity
data class UserRoom(
    @PrimaryKey
    var id: Long? = null,
    var f_name: String? = null,
    var l_name: String? = null,
    var birthday: String? = null,
    var avatr_url: String? = null
)