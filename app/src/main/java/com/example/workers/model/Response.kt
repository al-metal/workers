package com.example.workers.model

data class Response(
    var response: List<User>? = null
)

data class User(
    var f_name: String? = null,
    var l_name: String? = null,
    var birthday: String? = null,
    var avatr_url: String? = null,
    var specialty: List<Specialty>? = null
)

data class Specialty(
    var specialty_id: Int? = null,
    var name: String? = null
)
