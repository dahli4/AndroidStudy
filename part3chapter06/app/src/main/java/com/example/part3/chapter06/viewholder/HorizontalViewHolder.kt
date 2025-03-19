package com.example.part3.chapter06.viewholder

import com.example.part3.chapter06.ListAdapter
import com.example.part3.chapter06.databinding.ItemHorizontalBinding
import com.example.part3.chapter06.model.Horizontal
import com.example.part3.chapter06.model.ListItem

class HorizontalViewHolder(
    private val binding: ItemHorizontalBinding
) : BindingViewHolder<ItemHorizontalBinding>(binding) {
    private val adapter = ListAdapter()

    init {
        binding.listView.adapter = adapter
    }

    override fun bind(item: ListItem) {
        super.bind(item)
        item as Horizontal
        binding.titleTextView.text = item.title
        adapter.submitList(item.items)
    }
}