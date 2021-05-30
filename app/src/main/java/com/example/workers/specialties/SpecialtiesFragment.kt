package com.example.workers.specialties

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.workers.R
import com.example.workers.model.SpecialtyRoom

class SpecialtiesFragment : Fragment(), SpecialtiesContract.View,
    SpecialtiesAdapter.SpecClickListener {

    private lateinit var presenter: SpecialtiesContract.Presenter
    private lateinit var recyclerView: RecyclerView
    private lateinit var list: List<SpecialtyRoom>

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

    override fun showSpecialties(list: List<SpecialtyRoom>) {
        this.list = list
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = SpecialtiesAdapter(list, this)
    }

    override fun specClick(position: Int) {
        println(list[position].name)
        println(list[position].specialty_id)
        list[position].specialty_id?.let {
            (activity as? SpecialtiesContract.UsersListener)?.gotoUsers(
                it
            )
        }
    }
}