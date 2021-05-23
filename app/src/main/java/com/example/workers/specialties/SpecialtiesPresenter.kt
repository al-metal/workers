package com.example.workers.specialties

import com.example.workers.model.Response

class SpecialtiesPresenter(var view: SpecialtiesContract.View): SpecialtiesContract.Presenter {

    private val repository = SpecialtiesRepository()

    override fun init() {

        repository.getData(object : SpecialtiesContract.Callback {
            override fun onComplete(response: Response) {
                
            }

            override fun onError() {
                TODO("Not yet implemented")
            }
        })
    }
}