package com.dev.mvvm_repos.ui.detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.dev.mvvm_repos.R
import com.dev.mvvm_repos.databinding.ActivityUserDetailBinding
import com.dev.mvvm_repos.utils.loadImageWithCornerRadius
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserDetailActivity : AppCompatActivity() {

    private val viewModel: UserDetailViewModel by viewModel()
    private lateinit var binding: ActivityUserDetailBinding

    private var username: String? = null

    companion object {
        private const val EXTRA_DATA_USER = "EXTRA_DATA_USER"

        fun startIntent(
            context: Context, user: String
        ): Intent {
            return Intent(context, UserDetailActivity::class.java)
                .putExtra(EXTRA_DATA_USER, user)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        username = intent.getStringExtra(EXTRA_DATA_USER)

        viewModelObservers()

        viewModel.getUserDetails(username ?: "")

        binding.toolbarDetail.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun viewModelObservers() {
        viewModel.viewState.observe(this, Observer {
            when (it) {
                is DetailViewState.Success -> {
                    binding.ivPhoto.loadImageWithCornerRadius(
                        it.detail.avatarUrl,
                        R.dimen.detail_radius_photo,
                        R.drawable.baseline_on_error_24
                    )
                    binding.layoutMessageError.visibility = View.GONE
                    binding.tvUser.text = it.detail.login
                    binding.tvName.text = getString(R.string.string_name, it.detail.name)
                    binding.tvCompany.text = getString(R.string.string_company, it.detail.company)
                    binding.tvBlog.text = getString(R.string.string_blog, it.detail.blog)
                    binding.tvLocation.text =
                        getString(R.string.string_location, it.detail.location)
                    binding.tvRepos.text = getString(it.detail.publicRepos)
                }
                is DetailViewState.Failed -> {
                    binding.layoutMessageError.visibility = View.VISIBLE
                }
            }
        })
    }
}