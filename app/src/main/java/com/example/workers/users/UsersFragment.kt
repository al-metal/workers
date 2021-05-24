package com.example.workers.users

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.workers.R
import com.example.workers.model.SpecialtyFull

class UsersFragment : Fragment() {
    private var specFull: SpecialtyFull? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_users, container, false)

        return view
    }

    companion object {

        fun newInstance(specFull: SpecialtyFull): UsersFragment {
            val usersFragment = UsersFragment()
            usersFragment.specFull = specFull
            return usersFragment
        }
    }
}