package com.zn.zonaenglish.ui.home

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zn.zonaenglish.databinding.FragmentHomeBinding
import com.zn.zonaenglish.network.ApiClient
import com.zn.zonaenglish.network.ApiConfig
import com.zn.zonaenglish.repository.homerepository.HomeRemoteDataSource
import com.zn.zonaenglish.repository.homerepository.HomeRepository
import com.zn.zonaenglish.ui.home.infopromo.InfoPromoAdapter
import com.zn.zonaenglish.ui.home.infopromo.model.InfoPromoItem
import com.zn.zonaenglish.ui.home.studyvideo.detail.DetailStudyActivity
import com.zn.zonaenglish.ui.home.studyvideo.StudyVideoAdapter
import com.zn.zonaenglish.ui.home.studyvideo.model.StudyVideoResponseItem
import com.zn.zonaenglish.util.Const.API_KEY

class HomeFragment : Fragment(), HomeContract.View {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var apiClient: ApiClient
    private lateinit var homeRemoteDataSource: HomeRemoteDataSource
    private lateinit var repository: HomeRepository
    private lateinit var presenter: HomeContract.Presenter
    private val studyVideoAdapter: StudyVideoAdapter by lazy { StudyVideoAdapter() }
    private val infoPromoAdapter: InfoPromoAdapter by lazy { InfoPromoAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        apiClient = ApiConfig.apiClient()
        homeRemoteDataSource = HomeRemoteDataSource(apiClient)
        repository = HomeRepository(homeRemoteDataSource)

        studyVideoAdapter.onItemClick = { selectedData ->
            val intent = Intent(activity, DetailStudyActivity::class.java)
            intent.putExtra(DetailStudyActivity.EXTRA_TYPE, selectedData)
            startActivity(intent)
        }

        HomePresenter(this, repository)
        initView()
        initData()
    }

    private fun initView() {
        with(binding.rvStudyVideo) {
            setHasFixedSize(true)
            adapter = studyVideoAdapter
        }

        with(binding.rvInfoPromo) {
            setHasFixedSize(true)
            adapter = infoPromoAdapter
        }
    }

    private fun initData() {
        presenter.getTypeStudyVideo(API_KEY)
        presenter.getInfoPromo(API_KEY)
    }

    override fun setItemToView(typeStudyVideo: MutableList<StudyVideoResponseItem>) {
        studyVideoAdapter.setData(typeStudyVideo)
    }

    override fun setInfoPromo(infoPromo: List<InfoPromoItem>) {
        infoPromoAdapter.setData(infoPromo)
    }

    override fun setError(throwable: Throwable) {
        Log.d(TAG, "setError: $throwable")
    }

    override fun setPresenter(presenter: HomeContract.Presenter) {
        this.presenter = presenter
    }
}