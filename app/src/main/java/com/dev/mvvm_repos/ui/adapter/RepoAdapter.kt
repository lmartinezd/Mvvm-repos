package com.dev.mvvm_repos.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dev.mvvm_repos.R
import com.dev.mvvm_repos.data.model.UserRepo

class RepoAdapter : RecyclerView.Adapter<RepoAdapter.RepoHolder>() {

    var listRepository: List<UserRepo> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.repository_card_view, parent, false)
        return RepoHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listRepository.size
    }

    override fun onBindViewHolder(holder: RepoHolder, position: Int) {
        holder.bind(listRepository[position])
    }

    inner class RepoHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvName: TextView = itemView.findViewById(R.id.tvNameRepo)

        fun bind(item: UserRepo) {
            tvName.text = item.name
        }
    }
}