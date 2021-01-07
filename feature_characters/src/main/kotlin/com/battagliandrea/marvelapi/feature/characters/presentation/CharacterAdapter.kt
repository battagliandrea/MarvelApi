package com.battagliandrea.marvelapi.feature.characters.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.battagliandrea.marvelapi.core.delegate.observer
import com.battagliandrea.marvelapi.feature.characters.R
import com.battagliandrea.marvelapi.feature.characters.domain.model.CharacterDomainModel
import com.bumptech.glide.Glide
import javax.inject.Inject
import kotlinx.android.synthetic.main.fragment_character_list_item.view.*

internal class CharacterAdapter @Inject constructor() : RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    var characters: List<CharacterDomainModel> by observer(listOf()) {
        notifyDataSetChanged()
    }

    private var onDebouncedClickListener: ((character: CharacterDomainModel) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_character_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(characters[position])
    }

    override fun getItemCount(): Int = characters.size

    fun setOnDebouncedClickListener(listener: (character: CharacterDomainModel) -> Unit) {
        this.onDebouncedClickListener = listener
    }

    inner class ViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        private var url by observer<String?>(null) {

            if (it != null) {
                Glide.with(itemView.context)
                        .load(it)
                        .centerCrop()
                        .into(itemView.imageView)
            }
        }

        fun bind(domainModel: CharacterDomainModel) {
            itemView.setOnClickListener { onDebouncedClickListener?.invoke(domainModel) }
            Log.d("IMAGE_URL", domainModel.imageUrl)
            url = domainModel.imageUrl
        }
    }
}
