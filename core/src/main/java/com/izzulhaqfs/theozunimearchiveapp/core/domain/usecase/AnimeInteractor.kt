package com.izzulhaqfs.theozunimearchiveapp.core.domain.usecase

import com.izzulhaqfs.theozunimearchiveapp.core.data.Resource
import com.izzulhaqfs.theozunimearchiveapp.core.domain.model.Anime
import com.izzulhaqfs.theozunimearchiveapp.core.domain.repository.IAnimeRepository
import kotlinx.coroutines.flow.Flow

class AnimeInteractor(private val animeRepository: IAnimeRepository): AnimeUseCase {
    override fun getAnimeList(query: String): Flow<Resource<List<Anime>>> {
        return animeRepository.getAnimeList(query)
    }

    override fun getSeasonalAnime(year: Int, season: String): Flow<Resource<List<Anime>>> {
        return animeRepository.getSeasonalAnime(year, season)
    }

    override fun getAnimeRanking(rankingType: String): Flow<Resource<List<Anime>>> {
        return animeRepository.getAnimeRanking(rankingType)
    }

    override fun getFavoriteAnime(): Flow<List<Anime>> {
        return animeRepository.getFavoriteAnime()
    }

    override fun setFavoriteAnime(anime: Anime, state: Boolean) {
        animeRepository.setFavoriteAnime(anime, state)
    }
}