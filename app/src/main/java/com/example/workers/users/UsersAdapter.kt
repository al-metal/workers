package com.example.workers.users

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.workers.R
import com.example.workers.model.User

class UsersAdapter (private val list: MutableList<User>,
private val listener: UsersClickListener): RecyclerView.Adapter<UsersAdapter.ViewHolder>(){

    interface UsersClickListener{
        fun userClick()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        var firstName: TextView? = null
        var lastName: TextView? = null
        var age: TextView? = null

        init {
            firstName = itemView.findViewById(R.id.user_first_name_text)
            lastName = itemView.findViewById(R.id.user_last_name_text)
            age = itemView.findViewById(R.id.age)
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_users, parent, false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = list[position]
        holder?.firstName?.text = user.f_name
        holder?.lastName?.text = user.l_name
        holder?.age?.text = "0"
    }

    override fun getItemCount(): Int {
        return list.size
    }
}