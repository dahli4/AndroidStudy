package com.example.part3.chapter06.model

class Empty : ListItem {
    override val viewType: ViewType
        get() = ViewType.EMPTY
}