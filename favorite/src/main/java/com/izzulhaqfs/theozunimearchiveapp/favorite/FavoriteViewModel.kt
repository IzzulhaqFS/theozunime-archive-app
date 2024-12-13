package com.izzulhaqfs.theozunimearchiveapp.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.izzulhaqfs.theozunimearchiveapp.core.domain.usecase.AnimeUseCase

class FavoriteViewModel(animeUseCase: AnimeUseCase) : ViewModel() {
    val animes = animeUseCase.getFavoriteAnime().asLiveData()
}