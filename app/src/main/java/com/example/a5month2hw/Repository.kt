package com.example.a5month2hw

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.a5month2hw.model.LoveApi
import com.example.a5month2hw.model.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val api: LoveApi){


    fun getLove(firstName : String,secondName:String): MutableLiveData<LoveModel>{
        val love: MutableLiveData<LoveModel> = MutableLiveData()
        api.calculate(firstName,secondName).enqueue(object :Callback<LoveModel>{
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful){
                    love.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("ololo", "onFailure: ${t.message}" )
            }
        })

        return love
    }
}