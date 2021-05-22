package com.example.workers

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.workers.specialties.SpecialtiesFragment

class MainActivity : AppCompatActivity() {
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
}