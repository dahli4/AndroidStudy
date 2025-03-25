package com.example.part3.chapter07

import android.graphics.Paint
import androidx.recyclerview.widget.RecyclerView
import com.example.part3.chapter07.databinding.ItemContentBinding
import com.example.part3.chapter07.model.ContentEntity

class ContentViewHolder(
    private val binding: ItemContentBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ContentEntity) {
        binding.item = item

        binding.contentCheckBox.paintFlags = if (item.isDone) {
            binding.contentCheckBox.paintFlags + Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            0
        }
    }
}