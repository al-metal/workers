package com.example.workers.specialties

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.workers.R
import com.example.workers.model.SpecialtyRoom

class SpecialtiesAdapter(private val list: List<SpecialtyRoom>,
                         private val listener: SpecClickListener) :
    RecyclerView.Adapter<SpecialtiesAdapter.ViewHolder>() {

    interface SpecClickListener {
        fun specClick(position: Int)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var title: TextView? = null

        init {
            title = itemView.findViewById(R.id.title_specialties_text)
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            listener.specClick(adapterPosition)
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