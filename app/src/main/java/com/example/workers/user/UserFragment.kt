package com.example.workers.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.workers.R
import com.example.workers.model.User

class UserFragment : Fragment() {

    private var user: User? = null

    private lateinit var firstNameText: TextView
    private lateinit var lastNameText: TextView
    private lateinit var birthdayText: TextView
    private lateinit var ageText: TextView
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_user, container, false)

        firstNameText = view.findViewById(R.id.first_name_text)
        lastNameText = view.findViewById(R.id.last_name_text)
        birthdayText = view.findViewById(R.id.birthday_text)
        ageText = view.findViewById(R.id.age_text)
        recyclerView = view.findViewById(R.id.recycler)

        initData()

        return view
    }

    private fun initData() {
        firstNameText.text = user?.f_name ?: ""
        lastNameText.text = user?.l_name ?: ""
        birthdayText.text = user?.birthday ?: ""
        ageText.text = user?.birthday ?: ""

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = user?.specialty?.let { UserAdapter(it) }
    }

    companion object {
        fun newInstance(user: User): UserFragment {
            val userFragment = UserFragment()
            userFragment.user = user
            return userFragment
        }
    }
}