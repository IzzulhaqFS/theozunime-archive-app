package com.izzulhaqfs.theozunimearchiveapp.detail

import androidx.lifecycle.ViewModel
import com.izzulhaqfs.theozunimearchiveapp.core.domain.model.Anime
import com.izzulhaqfs.theozunimearchiveapp.core.domain.usecase.AnimeUseCase

class DetailAnimeViewModel(private val animeUseCase: AnimeUseCase) : ViewModel() {
    fun setFavoriteAnime(anime: Anime, status: Boolean) {
        animeUseCase.setFavoriteAnime(anime, status)
    }
}