package com.example.a5month2hw.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.a5month2hw.App
import com.example.a5month2hw.R
import com.example.a5month2hw.databinding.FragmentHomeBinding
import com.example.a5month2hw.model.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            btnCalculate.setOnClickListener {
                App.api.calculate(etBoy.text.toString(),etGirl.text.toString()).enqueue(object :
                    Callback<LoveModel> {
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        if (response.isSuccessful){
                            Log.e("ololo", "onResponse:${response.body()?.percentage} ")
                            val loveModel = response.body()
                            val bundle = Bundle()
                            bundle.putSerializable("love",loveModel)
                            findNavController().navigate(R.id.resultFragment,bundle)
                            etBoy.text.clear()
                            etGirl.text.clear()
                        }
                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        Log.e("ololo", "onFailure: ${t.message}" )
                    }

                })
            }
        }
    }
}