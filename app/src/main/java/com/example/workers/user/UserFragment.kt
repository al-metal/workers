package com.example.workers.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.workers.R
import com.example.workers.model.User

class UserFragment : Fragment() {

    private var user: User? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_user, container, false)
        return view
    }

    companion object {
        fun newInstance(user: User): UserFragment {
            val userFragment = UserFragment()
            userFragment.user = user
            return userFragment
        }
    }
}