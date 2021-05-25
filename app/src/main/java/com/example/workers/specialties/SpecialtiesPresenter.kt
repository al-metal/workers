package com.example.workers.specialties

import com.example.workers.model.Response
import com.example.workers.model.UserRoom
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SpecialtiesPresenter(var view: SpecialtiesContract.View) : SpecialtiesContract.Presenter {

    private val repository = SpecialtiesRepository()
    private val scope = CoroutineScope(Dispatchers.Default)

    override fun init() {
        scope.launch { repository.clearUsers() }
        repository.getData(object : SpecialtiesContract.Callback {
            override fun onComplete(response: Response) {
                if (response.response?.size ?: 0 > 0) {
                    scope.launch {
                        for (user in response.response!!) {
                            val userRoom = UserRoom()
                            userRoom.avatr_url = user.avatr_url
                            userRoom.f_name = user.f_name
                            userRoom.l_name = user.l_name
                            userRoom.birthday = user.birthday
                            if (!repository.isUser(user.l_name!!, user.f_name!!)) {
                                repository.insertUser(userRoom)
                            }
                        }
                        println("wqwqwqwqwqwqwqwq2${repository.getAllUser().size}")
                    }

                    val list = repository.getListSpec(response)
                    scope.launch {
                        println("wqwqwqwqwqwqwqwq2${repository.getAllUser().size}")
                    }
                    view.showSpecialties(list)

                } else {
                    TODO("вывести ошибку")
                }
            }

            override fun onError() {
                TODO("вывести ошибку")
            }
        })
    }
}