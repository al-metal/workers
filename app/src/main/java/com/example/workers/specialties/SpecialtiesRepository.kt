package com.example.workers.specialties

import android.util.Log
import com.example.workers.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SpecialtiesRepository : SpecialtiesContract.Repository {

    override fun getData(callback: SpecialtiesContract.Callback) {
        val api = ApiUtils.apiService

        api.getData().enqueue(object : Callback<com.example.workers.model.Response> {

            override fun onResponse(
                call: Call<com.example.workers.model.Response>,
                response: Response<com.example.workers.model.Response>
            ) {
                if (response.isSuccessful) {
                    Log.d("TAG", "onResponse: " + response.body())
                    // TODO показать список
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
}