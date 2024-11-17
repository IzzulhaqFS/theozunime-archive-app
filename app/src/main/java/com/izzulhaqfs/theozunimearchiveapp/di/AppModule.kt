package com.izzulhaqfs.theozunimearchiveapp.di

import com.izzulhaqfs.theozunimearchiveapp.core.domain.usecase.AnimeInteractor
import com.izzulhaqfs.theozunimearchiveapp.core.domain.usecase.AnimeUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory<AnimeUseCase> { AnimeInteractor(get()) }
}