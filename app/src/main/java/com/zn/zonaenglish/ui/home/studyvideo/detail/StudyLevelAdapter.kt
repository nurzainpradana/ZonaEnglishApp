package com.zn.zonaenglish.ui.home.studyvideo.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zn.zonaenglish.databinding.ItemListChooseLevelBinding
import com.zn.zonaenglish.ui.home.studyvideo.model.StudyLevelResponseItem

class StudyLevelAdapter : RecyclerView.Adapter<StudyLevelAdapter.ViewHolder>() {

    private var listChooseLevel = ArrayList<StudyLevelResponseItem>()

    fun setData(item: List<StudyLevelResponseItem>) {
        listChooseLevel.apply {
            clear()
            addAll(item)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int
    ): StudyLevelAdapter.ViewHolder {
        val bindingListLevel = ItemListChooseLevelBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(bindingListLevel)
    }

    override fun onBindViewHolder(holder: StudyLevelAdapter.ViewHolder, position: Int) {
        holder.bindData(listChooseLevel[position])
    }

    override fun getItemCount(): Int = listChooseLevel.size

    inner class ViewHolder(private val binding: ItemListChooseLevelBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun bindData(studyLevel: StudyLevelResponseItem) {
                with(binding) {
                    tvCodeLevel.text = studyLevel.name
                    tvLevel.text = studyLevel.remark1
                }
            }
    }
}