package com.jhernandes.upcomingmovies.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.jhernandes.upcomingmovies.R
import com.jhernandes.upcomingmovies.databinding.ItemMovieViewholderBinding
import com.jhernandes.upcomingmovies.databinding.MainFragmentBinding
import com.jhernandes.upcomingmovies.models.UpcomingMovie
import com.jhernandes.upcomingmovies.paging.MoviesPagedListAdapter
import org.koin.android.ext.android.inject

class MainFragment : Fragment(), MoviesPagedListAdapter.ItemClickedLister {

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
        return binding.main
    }

    override fun onStart() {
        super.onStart()
        setupRecycler()
    }

    private fun setupRecycler() {
        binding.main.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.main.itemAnimator = DefaultItemAnimator()

        val adapter = MoviesPagedListAdapter(this)
        binding.main.adapter = adapter

        viewModel.listLiveData!!.observe(this, Observer { adapter.submitList(it) })
    }

    override fun onItemClicked(
        movie: UpcomingMovie?) {
        val bundle = Bundle()
        bundle.putSerializable(MovieDetailFragment.EXTRA_MOVIE, movie)

        movie?.let {  MovieDetailFragment.getDialog(movie).show(fragmentManager, "") }

        // findNavController().navigate(R.id.action_mainFragment_to_movieDetailFragment, bundle)
    }

}
