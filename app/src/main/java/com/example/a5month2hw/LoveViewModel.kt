package com.example.a5month2hw

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.a5month2hw.model.LoveModel

class LoveViewModel: ViewModel() {

    private val  repository=Repository()


    fun getLiveModel(firstName:String,secondName:String):LiveData<LoveModel>{
        return repository.getLove(firstName , secondName )

    }
}