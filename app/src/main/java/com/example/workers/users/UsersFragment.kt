package com.example.workers.users

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.workers.R
import com.example.workers.model.SpecialtyFull
import com.example.workers.model.User
import com.example.workers.specialties.SpecialtiesAdapter

class UsersFragment : Fragment(), UsersAdapter.UsersClickListener {

    private var specialtyId: Int? = null

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_users, container, false)

        recyclerView = view.findViewById(R.id.users_recycler)
        recyclerView.layoutManager = LinearLayoutManager(context)
//        recyclerView.adapter = specFull?.userList?.let { UsersAdapter(it, this) }

        return view
    }

    companion object {

        fun newInstance(specialtyId: Int): UsersFragment {
            val usersFragment = UsersFragment()
            usersFragment.specialtyId = specialtyId
            return usersFragment
        }
    }

    override fun userClick(position: Int) {
//        specFull?.userList?.get(position)?.let { (activity as? UserListener)?.gotoUser(it) }
    }

    interface UserListener {
        fun gotoUser(user: User)
    }
}