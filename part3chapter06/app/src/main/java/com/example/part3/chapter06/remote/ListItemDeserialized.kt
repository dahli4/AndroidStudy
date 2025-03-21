package com.example.part3.chapter06.remote

import com.example.part3.chapter06.model.Coupon
import com.example.part3.chapter06.model.Empty
import com.example.part3.chapter06.model.FullAd
import com.example.part3.chapter06.model.Horizontal
import com.example.part3.chapter06.model.Image
import com.example.part3.chapter06.model.ListItem
import com.example.part3.chapter06.model.Sale
import com.example.part3.chapter06.model.SellItem
import com.example.part3.chapter06.model.ViewPager
import com.example.part3.chapter06.model.ViewType
import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class ListItemDeserialized : JsonDeserializer<ListItem> {
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): ListItem {
        val viewType = json.asJsonObject.getAsJsonPrimitive("viewType").asString
        val gson = GsonBuilder()
            .registerTypeAdapter(ListItem::class.java, ListItemDeserialized())
            .create()

        return try {
            when (viewType) {
                ViewType.VIEW_PAGER.name -> gson.fromJson(json, ViewPager::class.java)
                ViewType.HORIZONTAL.name -> gson.fromJson(json, Horizontal::class.java)
                ViewType.FULL_AD.name -> gson.fromJson(json, FullAd::class.java)
                ViewType.SALE.name -> gson.fromJson(json, Sale::class.java)
                ViewType.IMAGE.name -> gson.fromJson(json, Image::class.java)
                ViewType.SELL_ITEM.name -> gson.fromJson(json, SellItem::class.java)
                ViewType.COUPON.name -> gson.fromJson(json, Coupon::class.java)
                else -> gson.fromJson(json, Empty::class.java)
            }
        } catch (e: Exception) {
            gson.fromJson(json, Empty::class.java)
        }
    }
}