package com.example.workers.specialties

import com.example.workers.model.Response
import com.example.workers.model.Specialty

interface SpecialtiesContract {

    interface View {

        fun showSpecialties(list: List<Specialty>)

    }

    interface Presenter {

        fun init()

    }

    interface Repository {

        fun getData(callback: Callback)

        fun getListSpec(response: Response): MutableList<Specialty>

    }

    interface Callback {

        fun onComplete(response: Response)

        fun onError()
    }
}