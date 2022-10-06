package com.example.a5month2hw

import android.app.Application
import androidx.room.Room
import com.example.a5month2hw.model.LoveApi
import com.example.a5month2hw.model.RetrofitService
import com.example.a5month2hw.room.AppDataBase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {

    companion object{
        lateinit var db: AppDataBase
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(this, AppDataBase::class.java,"love-base").allowMainThreadQueries().build()

    }

}