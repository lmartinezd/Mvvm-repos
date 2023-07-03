package com.dev.mvvm_repos.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dev.mvvm_repos.R
import com.dev.mvvm_repos.data.model.User

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserHolder>() {

    var allUsers: List<User> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.user_card_view, parent, false)
        return UserHolder(itemView)
    }

    override fun getItemCount(): Int {
        return allUsers.size
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.bind(allUsers[position])
    }

    inner class UserHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvName: TextView = itemView.findViewById(R.id.tvUserName)
        private val ivImage: AppCompatImageView = itemView.findViewById(R.id.ivImage)

        private val options = RequestOptions().apply {
            fitCenter()
        }

        fun bind(item: User) {
            Glide.with(itemView.rootView.context)
                .load(item.avatarUrl)
                .apply(options)
                .into(ivImage)

            tvName.text = item.login
        }
    }
}