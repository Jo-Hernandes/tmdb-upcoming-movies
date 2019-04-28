package com.jhernandes.upcomingmovies.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.jhernandes.upcomingmovies.databinding.MainFragmentBinding
import com.jhernandes.upcomingmovies.paging.MoviesPagedListAdapter
import org.koin.android.ext.android.inject

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by inject()
    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        setupRecycler()
    }

    private fun setupRecycler() {
        binding.main.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.main.itemAnimator = DefaultItemAnimator()

        val adapter = MoviesPagedListAdapter()
        binding.main.adapter = adapter

        viewModel.listLiveData!!.observe(this, Observer { adapter.submitList(it) })
    }
}
