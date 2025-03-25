package com.example.part3.chapter07.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.part3.chapter07.data.dao.ContentDao
import com.example.part3.chapter07.model.ContentEntity

@Database(entities = [ContentEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun contentDao(): ContentDao
}
