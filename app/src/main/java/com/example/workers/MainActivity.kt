package com.example.workers

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.workers.model.SpecialtyFull
import com.example.workers.model.User
import com.example.workers.specialties.SpecialtiesContract
import com.example.workers.specialties.SpecialtiesFragment
import com.example.workers.user.UserFragment
import com.example.workers.users.UsersAdapter
import com.example.workers.users.UsersFragment

class MainActivity : AppCompatActivity(), SpecialtiesContract.UsersListener,
    UsersFragment.UserListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(SpecialtiesFragment())
    }

    override fun onBackPressed() {
        Log.d("TAG", "onBackPressed: ${supportFragmentManager.backStackEntryCount}")
        if (supportFragmentManager.backStackEntryCount == 1)
            finish()
        else
            super.onBackPressed()
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, fragment)
            addToBackStack(null)
            commit()
        }
    }

    override fun gotoUsers(specFull: SpecialtyFull) {
        val usersFragment = UsersFragment.newInstance(specFull)
        replaceFragment(usersFragment)
    }

    override fun gotoUser(user: User) {
        val userFragment = UserFragment.newInstance(user)
        replaceFragment(userFragment)
    }


}