package com.example.workers.specialties

import android.os.IBinder
import com.example.workers.model.Response
import com.example.workers.model.SpecialtyRoom
import com.example.workers.model.UserRoom
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SpecialtiesPresenter(var view: SpecialtiesContract.View) : SpecialtiesContract.Presenter {

    private val repository = SpecialtiesRepository()
    private val scope = CoroutineScope(Dispatchers.Default)
    private val scopeMain = CoroutineScope(Dispatchers.Main)

    override fun init() {
        scope.launch { repository.clearUsers() }
        repository.getData(object : SpecialtiesContract.Callback {
            override fun onComplete(response: Response) {
                if (response.response?.size ?: 0 > 0) {

                    parsingData(response)
                    showData()

                } else {
                    TODO("вывести ошибку")
                }
            }

            override fun onError() {
                TODO("вывести ошибку")
            }
        })
    }

    private fun parsingData(response: Response) {
        for (user in response.response!!) {
            val userRoom = UserRoom()
            userRoom.avatr_url = user.avatr_url
            userRoom.f_name = user.f_name
            userRoom.l_name = user.l_name
            userRoom.birthday = user.birthday
//            userRoom.specialtyList = user.specialty!![0].specialty_id
//            val list: MutableList<Int> = mutableListOf()
//            for (spec in user.specialty!!){
//                spec.specialty_id?.let { list.add(it) }
//            }
//            userRoom.specialtyList = list
            insertUserRoom(userRoom)

            for (s in user.specialty!!) {
                val spec = SpecialtyRoom()
                spec.name = s.name
                spec.specialty_id = s.specialty_id
                insertSpecialtyRoom(spec)
            }
        }
    }

    private fun insertUserRoom(user: UserRoom) {
        scope.launch { repository.insertUser(user) }
    }

    private fun insertSpecialtyRoom(specialty: SpecialtyRoom) {
        scope.launch { repository.insertSpec(specialty) }
    }

    private fun showData() {
        scopeMain.launch {
            view.showSpecialties(repository.getAllSpec())
        }
    }
}