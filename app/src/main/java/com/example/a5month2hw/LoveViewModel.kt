package com.example.a5month2hw

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.a5month2hw.model.LoveModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoveViewModel @Inject constructor(private val repository:Repository): ViewModel() {


    fun getLiveModel(firstName:String,secondName:String):LiveData<LoveModel>{
        return repository.getLove(firstName , secondName )

    }
}