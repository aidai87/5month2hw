package com.example.a5month2hw.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a5month2hw.App
import com.example.a5month2hw.HistoryAdapter
import com.example.a5month2hw.R
import com.example.a5month2hw.databinding.FragmentHistoryBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings

@AndroidEntryPoint
class HistoryFragment : Fragment() {

    lateinit var adapter: HistoryAdapter
    lateinit var binding: FragmentHistoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHistoryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeHistory()
    }

    private fun observeHistory() {
        App.db.historyDao().getAll().observe(viewLifecycleOwner) { data ->
            adapter = HistoryAdapter(data)
            binding.recyclerView.adapter = adapter
        }
    }
}