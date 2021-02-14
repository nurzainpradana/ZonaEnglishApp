package com.zn.zonaenglish.ui.home.studyvideo.detail

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.zn.zonaenglish.databinding.FragmentDetailStudyVideoBinding
import com.zn.zonaenglish.network.ApiClient
import com.zn.zonaenglish.network.ApiConfig
import com.zn.zonaenglish.repository.detailstudyrepository.StudyRemoteDataSource
import com.zn.zonaenglish.repository.detailstudyrepository.StudyRepository
import com.zn.zonaenglish.ui.home.studyvideo.model.StudyLevelResponseItem
import com.zn.zonaenglish.ui.home.studyvideo.model.StudyVideoResponseItem

class DetailStudyActivity : AppCompatActivity(), DetailStudyContract.View {

    private lateinit var studyVideo: StudyVideoResponseItem
    private lateinit var binding: FragmentDetailStudyVideoBinding
    private lateinit var apiClient: ApiClient
    private lateinit var studyRemoteDataSource: StudyRemoteDataSource
    private lateinit var repository: StudyRepository
    private lateinit var presenter: DetailStudyContract.Presenter
    private val studyLevelAdapter: StudyLevelAdapter by lazy { StudyLevelAdapter() }

    companion object {
        const val EXTRA_TYPE = "extra_type"
        private val TAG = DetailStudyActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentDetailStudyVideoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        apiClient = ApiConfig.apiClient()
        studyRemoteDataSource = StudyRemoteDataSource(apiClient)
        repository = StudyRepository(studyRemoteDataSource)

        val detailStudyVideo = intent.getParcelableExtra<StudyVideoResponseItem>(EXTRA_TYPE)
        showDetailStudyVideo(detailStudyVideo)

        presenter = DetailStudyPresenter(this, repository)
        studyVideo = detailStudyVideo?.code?.let { StudyVideoResponseItem(code = it) }!!

        initView()
        initData(studyVideo)
    }

    private fun showDetailStudyVideo(data: StudyVideoResponseItem?) {
        data.let {
            binding.tvTitleStudy.text = data?.name
            binding.tvDescStudy.text = data?.remark1
            Glide.with(this)
                .load(data?.remark2)
                .into(binding.imgViewStudyVideo)
        }
    }

    private fun initView() {
        with(binding.rvChooseLevel) {
            setHasFixedSize(true)
            adapter = studyLevelAdapter
        }
    }

    private fun initData(studyVideo: StudyVideoResponseItem) {
        presenter.getStudyLevel(studyVideo.code)
    }

    override fun setLevelToView(studyLevel: MutableList<StudyLevelResponseItem>) {
        binding.pgBarChooseLevel.visibility = View.VISIBLE
        binding.rvChooseLevel.visibility = View.VISIBLE
        studyLevelAdapter.setData(studyLevel)
    }

    override fun setError(throwable: Throwable) {
        Log.d(TAG, "setError: $throwable")
    }

    override fun setPresenter(presenter: DetailStudyContract.Presenter) {
        this.presenter = presenter
    }
}