package com.example.part3.chapter06.viewholder

import com.example.part3.chapter06.ListAdapter
import com.example.part3.chapter06.databinding.ItemViewpagerBinding
import com.example.part3.chapter06.model.ListItem
import com.example.part3.chapter06.model.ViewPager

class ViewPagerViewHolder(
    binding: ItemViewpagerBinding
) : BindingViewHolder<ItemViewpagerBinding>(binding) {

    private val adapter = ListAdapter()

    init {
        binding.viewPager.adapter = adapter
    }

    override fun bind(item: ListItem) {
        super.bind(item)

        item as ViewPager
        adapter.submitList(item.items)
    }
}