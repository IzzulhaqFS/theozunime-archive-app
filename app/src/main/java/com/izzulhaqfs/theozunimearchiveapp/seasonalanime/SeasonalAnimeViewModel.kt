package com.izzulhaqfs.theozunimearchiveapp.seasonalanime

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.izzulhaqfs.theozunimearchiveapp.core.data.Resource
import com.izzulhaqfs.theozunimearchiveapp.core.domain.model.Anime
import com.izzulhaqfs.theozunimearchiveapp.core.domain.usecase.AnimeUseCase

class SeasonalAnimeViewModel(private val animeUseCase: AnimeUseCase) : ViewModel() {
    fun getSeasonalAnime(year: Int, season: String): LiveData<Resource<List<Anime>>> {
        return animeUseCase.getSeasonalAnime(year, season).asLiveData()
    }
}