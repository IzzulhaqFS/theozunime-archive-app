package com.izzulhaqfs.theozunimearchiveapp.core.data.source.local

import com.izzulhaqfs.theozunimearchiveapp.core.data.source.local.entity.AnimeEntity
import com.izzulhaqfs.theozunimearchiveapp.core.data.source.local.room.AnimeDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val animeDao: AnimeDao) {
    fun getAnimeList(query: String): Flow<List<AnimeEntity>> = animeDao.getAnimeList(query)

    fun getSeasonalAnime(year: Int, season: String): Flow<List<AnimeEntity>> =
        animeDao.getSeasonalAnime(year, season)

    fun getFavoriteAnime(): Flow<List<AnimeEntity>> = animeDao.getFavoriteAnime()

    fun getAnimeRanking(): Flow<List<AnimeEntity>> = animeDao.getAnimeRanking()

    suspend fun insertAnime(animes: List<AnimeEntity>) = animeDao.insertAnime(animes)

    fun setFavoriteAnime(anime: AnimeEntity, state: Boolean) {
        anime.isFavorite = state
        animeDao.updateFavoriteAnime(anime)
    }
}