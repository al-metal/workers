package com.example.workers.model

data class SpecialtyFull(
    var specialty_id: Int? = null,
    var name: String? = null,
    var userList: MutableList<User>? = mutableListOf()
)
