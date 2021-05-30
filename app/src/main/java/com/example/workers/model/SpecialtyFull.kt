package com.example.workers.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters

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
    var avatr_url: String? = null,
    var specList: List<Int>? = null
)

@Entity
data class SpecialtyRoom(
    @PrimaryKey
    var specialty_id: Int? = null,
    var name: String? = null
)

class SpecialtyConverter {
    @TypeConverter
    fun fromSpecList(specList: List<Int>?): String? {
        val list = specList?.map { it.toString() }
        return list?.joinToString { "," }
    }

    @TypeConverter
    fun toSpecList(data: String): List<Int>? {
        val list = data.split(",")
        return list.map { it.toInt() }
    }
}