package com.example.part3.chapter06.viewholder

import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import android.view.ViewGroup
import com.example.part3.chapter06.databinding.ItemEmptyBinding
import com.example.part3.chapter06.model.ViewType

object ViewHolderGenerator {
    fun get (
        parent: ViewGroup,
        viewType:Int
    ) :BindingViewHolder<*> {
        return when(viewType) {
            ViewType.VIEW_PAGER.ordinal -> ViewPagerViewHolder(parent.toBinding())
            ViewType.HORIZONTAL.ordinal -> HorizontalViewHolder(parent.toBinding())
            ViewType.FULL_AD.ordinal -> FullAdViewHolder(parent.toBinding())

            ViewType.SALE.ordinal -> SaleViewHolder(parent.toBinding())
            ViewType.IMAGE.ordinal -> ImageViewHolder(parent.toBinding())
            ViewType.SELL_ITEM.ordinal -> SellItemViewHolder(parent.toBinding())
            ViewType.COUPON.ordinal -> CouponViewHolder(parent.toBinding())
            else -> ItemViewHolder(parent.toBinding())
        }
    }

    class ItemViewHolder(binding:ItemEmptyBinding) : BindingViewHolder<ItemEmptyBinding>(binding)

    private inline fun <reified V: ViewBinding> ViewGroup.toBinding() : V {
        return V::class.java.getMethod(
            "inflate",
            LayoutInflater::class.java,
            ViewGroup::class.java,
            Boolean::class.java
        ).invoke(null, LayoutInflater.from(context), this, false) as V
    }
}