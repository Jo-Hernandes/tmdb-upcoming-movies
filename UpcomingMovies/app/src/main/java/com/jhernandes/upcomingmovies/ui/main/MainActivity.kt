package com.jhernandes.upcomingmovies.ui.main

import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.jhernandes.upcomingmovies.R
import com.jhernandes.upcomingmovies.commons.BaseActivity
import com.jhernandes.upcomingmovies.databinding.MainActivityBinding
import com.jhernandes.upcomingmovies.models.UpcomingMovie
import com.jhernandes.upcomingmovies.paging.MoviesPagedListAdapter
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity(), MoviesPagedListAdapter.ItemClickedLister {

    private lateinit var binding : MainActivityBinding
    private val viewModel : MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        (menu.findItem(R.id.menu_search).actionView as SearchView).setOnQueryTextListener(viewModel)
        (menu.findItem(R.id.menu_search).actionView as SearchView).setOnCloseListener {
            setupRecycler(false)
            true
        }
        return true
    }

    override fun onStart() {
        super.onStart()
        setupRecycler(false)
        viewModel.isQueryLiveData.observe(this, Observer { setupRecycler(it) })

    }

    private fun setupRecycler(isQuery : Boolean) {
        binding.main.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.main.itemAnimator = DefaultItemAnimator()

        val adapter = MoviesPagedListAdapter(this)
        binding.main.adapter = adapter

        if (!isQuery){
            viewModel.listLiveData!!.observe(this, Observer { adapter.submitList(it) })
        } else {
            viewModel.queryLiveData?.observe(this, Observer { adapter.submitList(it) })
        }
    }

    override fun onItemClicked(
        movie: UpcomingMovie?) {
        val bundle = Bundle()
        bundle.putSerializable(MovieDetailFragment.EXTRA_MOVIE, movie)
        movie?.let {  MovieDetailFragment.getDialog(movie).show(supportFragmentManager, "") }
    }


}
