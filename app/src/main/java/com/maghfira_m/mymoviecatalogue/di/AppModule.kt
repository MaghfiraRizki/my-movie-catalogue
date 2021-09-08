package com.maghfira_m.mymoviecatalogue.di

import com.maghfira_m.mymoviecatalogue.core.domain.usecase.MovieInteractor
import com.maghfira_m.mymoviecatalogue.core.domain.usecase.MovieUseCase
import com.maghfira_m.mymoviecatalogue.detail.DetailMovieViewModel
import com.maghfira_m.mymoviecatalogue.movie.MovieViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get()) }
}

val viewModelModule = module {
    viewModel { MovieViewModel(get()) }
    viewModel { DetailMovieViewModel(get()) }
}