package com.example.a5month2hw.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.a5month2hw.App
import com.example.a5month2hw.LoveViewModel
import com.example.a5month2hw.R
import com.example.a5month2hw.databinding.FragmentHomeBinding
import com.example.a5month2hw.model.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: LoveViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            btnCalculate.setOnClickListener {
                val firstName = etBoy.text.toString()
                val secondName = etGirl.text.toString()
                viewModel.getLiveModel(firstName,secondName).observe(viewLifecycleOwner
                ) { loveModel ->
                    Log.e("ololo", "initClickers: $loveModel")
                    val bundle = Bundle()
                    bundle.putSerializable("love", loveModel)
                    findNavController().navigate(R.id.resultFragment, bundle)
                    etBoy.text.clear()
                    etGirl.text.clear()
                }
            }
        }
    }
}