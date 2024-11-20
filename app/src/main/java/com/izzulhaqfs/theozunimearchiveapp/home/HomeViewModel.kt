package com.izzulhaqfs.theozunimearchiveapp.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.izzulhaqfs.theozunimearchiveapp.core.domain.usecase.AnimeUseCase

class HomeViewModel(animeUseCase: AnimeUseCase) : ViewModel() {
    val animes = animeUseCase.getAnimeRanking("all").asLiveData()
}