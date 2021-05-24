package com.example.workers.specialties

import com.example.workers.model.Response
import com.example.workers.model.Specialty
import com.example.workers.model.SpecialtyFull

interface SpecialtiesContract {

    interface View {

        fun showSpecialties(list: MutableList<SpecialtyFull>)

    }

    interface Presenter {

        fun init()

    }

    interface Repository {

        fun getData(callback: Callback)

        fun getListSpec(response: Response): MutableList<SpecialtyFull>

    }

    interface Callback {

        fun onComplete(response: Response)

        fun onError()
    }
}