package com.jhernandes.upcomingmovies.paging

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.jhernandes.upcomingmovies.models.UpcomingMovie

class MoviesPagedListAdapter : PagedListAdapter<UpcomingMovie, MovieViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder = MovieViewHolder.create(parent)

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.binding.movie = getItem(position)
    }

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<UpcomingMovie>() {
            override fun areItemsTheSame(oldItem: UpcomingMovie, newItem: UpcomingMovie):
                Boolean = oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: UpcomingMovie, newItem: UpcomingMovie):
                Boolean = oldItem.movieResume == newItem.movieResume
        }
    }


}