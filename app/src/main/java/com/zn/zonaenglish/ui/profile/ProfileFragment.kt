package com.zn.zonaenglish.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zn.zonaenglish.R
import com.zn.zonaenglish.databinding.FragmentProfileBinding
import com.zn.zonaenglish.hawkstorage.HawkStorage
import com.zn.zonaenglish.network.ApiClient
import com.zn.zonaenglish.network.ApiConfig
import com.zn.zonaenglish.repository.homerepository.HomeRemoteDataSource
import com.zn.zonaenglish.repository.profilerepository.ProfileRemoteRepository
import com.zn.zonaenglish.repository.profilerepository.ProfileRepository
import com.zn.zonaenglish.ui.login.LoginScreenActivity
import com.zn.zonaenglish.ui.profile.model.LogoutResponse

class ProfileFragment : Fragment(), ProfileContract.View {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var apiClient: ApiClient
    private lateinit var profileRemoteDataSource: ProfileRemoteRepository
    private lateinit var repository: ProfileRepository
    private lateinit var presenter: ProfileContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //Init
        apiClient = ApiConfig.apiClient()
        profileRemoteDataSource = ProfileRemoteRepository(apiClient, context)
        repository = ProfileRepository(profileRemoteDataSource)

        ProfilePresenter(this, repository)

        initDataProfile()

        presenter.getTypeLogout()
        onClick()
    }

    private fun onClick() {
        binding.btnLogout.setOnClickListener {
            presenter.getTypeLogout()
            val intent = Intent(context, LoginScreenActivity::class.java)
            startActivity(intent)
            activity?.finishAffinity()
        }
    }

    private fun initDataProfile() {
        val user = HawkStorage.instance(context).getUser()
        binding.tvName.text = user.name
        binding.tvPhoneNumber.text = user.noPhone.toString()
    }

    override fun setMoveToLogin(logoutUser: LogoutResponse) {

    }

    override fun setError(throwable: Throwable) {

    }

    override fun setPresenter(presenter: ProfileContract.Presenter) {
        this.presenter = presenter
    }
}