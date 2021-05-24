package com.example.workers.specialties

import android.util.Log
import com.example.workers.ApiUtils
import com.example.workers.model.Specialty
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

    override fun getListSpec(response: com.example.workers.model.Response): MutableList<Specialty> {
        var list: MutableList<Specialty> = mutableListOf()

        for (user in response.response!!) {
            for (spec in user.specialty!!) {
                if (!list.contains(spec))
                    list.add(spec)
            }
        }

        return list
    }
}