package com.example.workers.specialties

import com.example.workers.model.Response

class SpecialtiesPresenter(var view: SpecialtiesContract.View): SpecialtiesContract.Presenter {

    private val repository = SpecialtiesRepository()

    override fun init() {

        repository.getData(object : SpecialtiesContract.Callback {
            override fun onComplete(response: Response) {
                if (response.response?.size ?: 0 > 0){
                    val list = repository.getListSpec(response)
                    view.showSpecialties(list)
                }else{
                    TODO("вывести ошибку")
                }
            }

            override fun onError() {
                 TODO("вывести ошибку")
            }
        })
    }
}