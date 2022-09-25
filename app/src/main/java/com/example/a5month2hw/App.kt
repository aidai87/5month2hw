package com.example.a5month2hw

import android.app.Application
import com.example.a5month2hw.model.LoveApi
import com.example.a5month2hw.model.RetrofitService

class App: Application() {

    companion object{
        lateinit var api: LoveApi
    }

    override fun onCreate() {
        super.onCreate()
        val retrofitService = RetrofitService()
        api = retrofitService.getLoveApi()
    }
}