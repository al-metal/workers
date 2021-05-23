package com.example.workers.specialties

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.workers.R
import com.example.workers.model.Specialty

class SpecialtiesFragment : Fragment(), SpecialtiesContract.View {

    lateinit var presenter: SpecialtiesContract.Presenter
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_specialties, container, false)

        recyclerView = view.findViewById(R.id.specialties_recycler)
        presenter = SpecialtiesPresenter(this)
        presenter.init()

        return view
    }

    override fun showSpecialties(list: List<Specialty>) {
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = SpecialtiesAdapter(list)
    }
}