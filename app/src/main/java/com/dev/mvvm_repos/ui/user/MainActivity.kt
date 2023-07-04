package com.dev.mvvm_repos.ui.user

import androidx.appcompat.app.AppCompatActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.dev.mvvm_repos.databinding.ActivityMainBinding
import com.dev.mvvm_repos.ui.adapter.UserAdapter

class MainActivity : AppCompatActivity() {

    private val viewModel: UserViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModelObservers()
        viewModel.listAllUsers()
        adapter = UserAdapter()

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.rvCharacter.layoutManager = LinearLayoutManager(this)
        binding.rvCharacter.adapter = adapter
        binding.rvCharacter.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )
    }

    private fun viewModelObservers() {
        viewModel.viewState.observe(this, Observer {
            when (it) {
                is UserViewState.Loading -> {
                    binding.layoutProgressBar.visibility = View.VISIBLE
                    binding.layoutMessageError.visibility = View.GONE

                }
                is UserViewState.Success -> {
                    binding.layoutMessageError.visibility = View.GONE
                    binding.layoutProgressBar.visibility = View.GONE
                    adapter.allUsers = it.listUsers
                }
                is UserViewState.Failed -> {
                    binding.layoutProgressBar.visibility = View.GONE
                    binding.layoutMessageError.visibility = View.VISIBLE
                }
            }
        })
    }
}