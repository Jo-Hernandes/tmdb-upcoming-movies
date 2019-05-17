package com.jhernandes.upcomingmovies.paging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jhernandes.datamodule.models.MovieGenre
import com.jhernandes.upcomingmovies.databinding.ItemMovieViewholderBinding

class MovieViewHolder(val binding: ItemMovieViewholderBinding) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create (parent : ViewGroup) : MovieViewHolder {
            val inflater = LayoutInflater.from(parent.context)
           return MovieViewHolder(ItemMovieViewholderBinding.inflate(inflater))
        }
    }

    fun showGenreListItems(genres : List<MovieGenre>?) {
       genres?.let {  binding.textviewThumbGenresLabel.text = genres.joinToString(separator = ", ", transform = { it.name }) }
    }
}