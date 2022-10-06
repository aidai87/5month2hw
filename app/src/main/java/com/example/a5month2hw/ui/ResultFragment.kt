package com.example.a5month2hw.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.a5month2hw.R
import com.example.a5month2hw.databinding.FragmentResultBinding
import com.example.a5month2hw.model.LoveModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        result()
    }

    private fun result() {
        val love = arguments?.getSerializable("love") as LoveModel
        with(binding) {
            etBoy.text = love.firstName
            etGirl.text = love.secondName
            tvResult.text = love.result
            tvPercentage.text = love.percentage.plus("%")
            btnTryAgain.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

}