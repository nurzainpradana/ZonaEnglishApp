package com.zn.zonaenglish.ui.home.studyvideo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.zn.zonaenglish.R
import com.zn.zonaenglish.databinding.ItemListStudyVideoBinding
import com.zn.zonaenglish.ui.home.studyvideo.model.StudyVideoResponseItem

class StudyVideoAdapter : RecyclerView.Adapter<StudyVideoAdapter.ViewHolder>() {

    private var listStudyVideo = ArrayList<StudyVideoResponseItem>()
    var onItemClick: ((StudyVideoResponseItem) -> Unit)? = null

    fun setData(item: List<StudyVideoResponseItem>) {
        listStudyVideo.apply {
            clear()
            addAll(item)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
    : StudyVideoAdapter.ViewHolder {
        val itemListVideoBinding = ItemListStudyVideoBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(itemListVideoBinding)
    }

    override fun onBindViewHolder(holder: StudyVideoAdapter.ViewHolder, position: Int) {
        holder.bindData(listStudyVideo[position])
    }

    override fun getItemCount(): Int = listStudyVideo.size

    inner class ViewHolder(private val binding: ItemListStudyVideoBinding)
        : RecyclerView.ViewHolder(binding.root) {

            fun bindData(studyVideo: StudyVideoResponseItem) {
                with(binding) {
                    tvTitleStudyVideo.text = studyVideo.name
                    Glide.with(itemView.context)
                        .load(itemView.context.getString(R.string.url_image, studyVideo.remark2))
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .into(imgViewStudyVideo)
                }

            }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listStudyVideo[adapterPosition])
            }
        }
    }
}