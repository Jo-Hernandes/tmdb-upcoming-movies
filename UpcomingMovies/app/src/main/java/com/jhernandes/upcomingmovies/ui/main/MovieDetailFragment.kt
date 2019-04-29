package com.jhernandes.upcomingmovies.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.jhernandes.datamodule.models.MovieGenre
import com.jhernandes.upcomingmovies.R
import com.jhernandes.upcomingmovies.databinding.MovieDetailFragmentBinding
import com.jhernandes.upcomingmovies.models.UpcomingMovie

class MovieDetailFragment : DialogFragment() {

    companion object {
        const val EXTRA_MOVIE: String = "movie_details_to_show"

        fun getDialog(movie : UpcomingMovie): MovieDetailFragment {
            val dialog = MovieDetailFragment()
            val arguments = Bundle()
            arguments.putSerializable(EXTRA_MOVIE, movie)
            dialog.arguments = arguments
            dialog.setStyle( STYLE_NO_FRAME, R.style.Base_ThemeOverlay_AppCompat_Dialog_Alert )

            return dialog
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.setCanceledOnTouchOutside(true)

        val detailFragmentBinding = MovieDetailFragmentBinding.inflate(inflater, container, false)
        val upcomingMovie = arguments?.getSerializable(EXTRA_MOVIE) as UpcomingMovie?
        detailFragmentBinding.movie = upcomingMovie
        showGenreString(detailFragmentBinding.textviewDetailsGenres, upcomingMovie?.namedGenresList)
        return detailFragmentBinding.root
    }

    private fun showGenreString (view : TextView, genres : List<MovieGenre>?) {
        if (genres.isNullOrEmpty()) {
            view.visibility = GONE
        } else {
            view.text = genres.joinToString(separator = " - ", transform = { it.name })
        }
    }


}
