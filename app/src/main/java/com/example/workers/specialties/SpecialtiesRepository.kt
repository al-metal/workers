package com.example.workers.specialties

import android.util.Log
import com.example.workers.ApiUtils
import com.example.workers.model.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SpecialtiesRepository : SpecialtiesContract.Repository {

    private val userDao: UserDao = Database.instance.userDao()
    private val specDao: SpecialtyDao = Database.instance.specDao()

    override fun getData(callback: SpecialtiesContract.Callback) {
        val api = ApiUtils.apiService

        api.getData().enqueue(object : Callback<com.example.workers.model.Response> {

            override fun onResponse(
                call: Call<com.example.workers.model.Response>,
                response: Response<com.example.workers.model.Response>
            ) {
                if (response.isSuccessful) {
                    Log.d("TAG", "onResponse: " + response.body())
                    response.body()?.let { callback.onComplete(it) }
                } else {
                    // TODO вывести ошибку
                }
            }

            override fun onFailure(call: Call<com.example.workers.model.Response>, t: Throwable) {
                Log.e("TAG", "onFailure: ", t)
                // TODO вывести ошибку
            }
        })
    }

    override suspend fun getAllUser(): List<UserRoom> {
        return userDao.getAllUsers()
    }

    override suspend fun insertUser(user: UserRoom) {
        userDao.insertUser(user)
    }

    override suspend fun isUser(l_name: String, f_name: String): Boolean {
        return userDao.isUsers(l_name, f_name)
    }

    override suspend fun clearUsers() {
        userDao.clearUsers()
    }

    override suspend fun insertSpec(specRoom: SpecialtyRoom) {
        specDao.insertSpec(specRoom)
    }

    override suspend fun getAllSpec(): List<SpecialtyRoom> {
        return specDao.getAllSpec()
    }
}