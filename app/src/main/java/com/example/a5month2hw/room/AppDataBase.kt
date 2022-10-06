package com.example.a5month2hw.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.a5month2hw.model.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDataBase : RoomDatabase(){

    abstract fun historyDao():HistoryDao
}