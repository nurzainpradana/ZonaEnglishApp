package com.zn.zonaenglish.ui.home.infopromo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zn.zonaenglish.R
import com.zn.zonaenglish.databinding.ItemListInfoPromoBinding
import com.zn.zonaenglish.ui.home.infopromo.model.InfoPromoItem
import com.zn.zonaenglish.ui.home.studyvideo.model.StudyVideoResponseItem

class InfoPromoAdapter : RecyclerView.Adapter<InfoPromoAdapter.ViewHolder>() {

    private var listInfoPromo = ArrayList<InfoPromoItem>()
    var onItemClick: ((StudyVideoResponseItem) -> Unit)? = null

    fun setData(item: List<InfoPromoItem>) {
        listInfoPromo.apply {
            clear()
            addAll(item)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoPromoAdapter.ViewHolder {
        val binding = ItemListInfoPromoBinding.inflate(
            LayoutInflater.from(
                parent.context
            ), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: InfoPromoAdapter.ViewHolder, position: Int) {
        holder.bindData(listInfoPromo[position])
    }

    override fun getItemCount(): Int = listInfoPromo.size

    inner class ViewHolder(private val binding: ItemListInfoPromoBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bindData(infoPromo: InfoPromoItem) {
                with(binding) {
                    Glide.with(itemView.context)
                        .load(itemView.context.getString(R.string.url_image, infoPromo.picture))
                        .into(imgPosterInfoPromo)
                }
            }
    }
}