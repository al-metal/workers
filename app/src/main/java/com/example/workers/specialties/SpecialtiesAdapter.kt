package com.example.workers.specialties

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.workers.R
import com.example.workers.model.Specialty

class SpecialtiesAdapter(private val list: List<Specialty>) :
    RecyclerView.Adapter<SpecialtiesAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView? = null

        init {
            title = itemView.findViewById(R.id.title_specialties_text)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_specialties, parent, false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title?.text = list.get(position).name
    }

    override fun getItemCount(): Int {
        return list.size
    }
}