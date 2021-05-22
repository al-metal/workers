package com.example.workers.specialties

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.workers.R

class SpecialtiesFragment : Fragment(), SpecialtiesContract.View {

    lateinit var presenter: SpecialtiesContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_specialties, container, false)

        presenter = SpecialtiesPresenter(this)
        presenter.init()

        return view
    }
}