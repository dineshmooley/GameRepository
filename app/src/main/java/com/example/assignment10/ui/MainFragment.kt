package com.example.assignment10.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.assignment10.R
import com.example.assignment10.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_main, container, false
        )
        val application = requireNotNull(activity).application
        val factory = MainViewModelFactory(application)
        val viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        val adapter = MainAdapter()


        viewModel.playlist.observe(viewLifecycleOwner, Observer {
            if (null != it) {
                adapter.games = it
                binding.recyclerView.adapter = adapter
                println("playlistChanged" + it)
            }
        })

        return binding.root
    }
}

