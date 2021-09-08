package com.maghfira_m.mymoviecatalogue.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.maghfira_m.mymoviecatalogue.R
import com.maghfira_m.mymoviecatalogue.core.domain.model.Movie
import com.maghfira_m.mymoviecatalogue.core.utils.Config
import com.maghfira_m.mymoviecatalogue.databinding.ActivityDetailMovieBinding
import kotlinx.android.synthetic.main.activity_detail_movie.*
import org.koin.android.viewmodel.ext.android.viewModel

class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val detailMovieViewModel: DetailMovieViewModel by viewModel()
    private lateinit var binding: ActivityDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white)

        collapsing_toolbar.setExpandedTitleColor(
            ContextCompat.getColor(
                this,
                R.color.color_on_primary
            )
        )
        collapsing_toolbar.setCollapsedTitleTextColor(
            ContextCompat.getColor(
                this,
                R.color.color_on_primary
            )
        )

        val detailMovie = intent.getParcelableExtra<Movie>(EXTRA_DATA)
        showDetailMovie(detailMovie)
    }

    private fun showDetailMovie(movie: Movie?) {
        movie.let {
            collapsing_toolbar.title = movie?.title

            Glide.with(this)
                .load(Config.IMAGE_URL + movie?.posterPath)
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                )
                .into(binding.imgPoster)

            binding.content.tvTagline.text = movie?.tagLine
            binding.content.tvReleaseDate.text = movie?.releaseDate
            binding.content.tvRating.text =
                resources.getString(R.string.voteAverage, movie?.voteAverage.toString())
            binding.content.tvOverview.text = movie?.overview

            val movieId = movie?.movieId
            if (movieId != null) {
                detailMovieViewModel.checkFavoriteMovie(movieId).observe(this, Observer { count ->
                    if (count == 0) {
                        setFavorite(false, movie)
                    } else {
                        setFavorite(true, movie)
                    }
                })
            }
        }
    }

    private fun setFavorite(statusFavorite: Boolean, movie: Movie) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite))
            binding.fab.setOnClickListener {
                detailMovieViewModel.deleteFavoriteMovie(movie)
            }
        } else {
            binding.fab.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_favorite_border
                )
            )
            binding.fab.setOnClickListener {
                detailMovieViewModel.insertFavoriteMovie(movie)
            }
        }
    }
}