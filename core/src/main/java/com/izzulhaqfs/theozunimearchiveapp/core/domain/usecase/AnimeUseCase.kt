package com.izzulhaqfs.theozunimearchiveapp.core.domain.usecase

import com.izzulhaqfs.theozunimearchiveapp.core.data.Resource
import com.izzulhaqfs.theozunimearchiveapp.core.domain.model.Anime
import kotlinx.coroutines.flow.Flow

interface AnimeUseCase {
    fun getAnimeList(query: String): Flow<Resource<List<Anime>>>
    fun getSeasonalAnime(year: Int, season: String): Flow<Resource<List<Anime>>>
    fun getAnimeRanking(rankingType: String): Flow<Resource<List<Anime>>>
    fun getFavoriteAnime(): Flow<List<Anime>>
    fun setFavoriteAnime(anime: Anime, state: Boolean)
}