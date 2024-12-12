package com.izzulhaqfs.theozunimearchiveapp.di

import com.izzulhaqfs.theozunimearchiveapp.core.domain.usecase.AnimeInteractor
import com.izzulhaqfs.theozunimearchiveapp.core.domain.usecase.AnimeUseCase
import com.izzulhaqfs.theozunimearchiveapp.detail.DetailAnimeViewModel
import com.izzulhaqfs.theozunimearchiveapp.home.HomeViewModel
import com.izzulhaqfs.theozunimearchiveapp.seasonalanime.SeasonalAnimeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<AnimeUseCase> { AnimeInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailAnimeViewModel(get()) }
    viewModel { SeasonalAnimeViewModel(get()) }
}