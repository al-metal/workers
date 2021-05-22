package com.example.workers.specialties

import com.example.workers.model.Response

interface SpecialtiesContract {

    interface View {

    }

    interface Presenter {

        fun init()

    }

    interface Repository {

        fun getData(callback: Callback)

    }

    interface Callback {

        fun onComplete(response: Response)

        fun onError()
    }
}