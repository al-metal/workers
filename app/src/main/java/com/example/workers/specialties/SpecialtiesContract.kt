package com.example.workers.specialties

import com.example.workers.model.Response
import com.example.workers.model.Specialty
import com.example.workers.model.SpecialtyFull
import com.example.workers.model.UserRoom

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

        suspend fun getAllUser(): List<UserRoom>

        suspend fun insertUser(user: UserRoom)

        suspend fun isUser(l_name: String, f_name: String): Boolean

        suspend fun clearUsers()

    }

    interface Callback {

        fun onComplete(response: Response)

        fun onError()
    }

    interface UsersListener{
        fun gotoUsers(specFull: SpecialtyFull)
    }
}