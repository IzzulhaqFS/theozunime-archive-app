package com.izzulhaqfs.theozunimearchiveapp.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.izzulhaqfs.theozunimearchiveapp.core.data.source.local.entity.AnimeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AnimeDao {
    @Query("SELECT * FROM anime WHERE title LIKE :query")
    fun getAnimeList(query: String): Flow<List<AnimeEntity>>

    @Query("SELECT * FROM anime WHERE start_year = :year AND start_season = :season")
    fun getSeasonalAnime(year: Int, season: String): Flow<List<AnimeEntity>>

    @Query("SELECT * FROM anime WHERE is_favorite = 1")
    fun getFavoriteAnime(): Flow<List<AnimeEntity>>

    @Query("SELECT * FROM anime ORDER BY mean DESC LIMIT 100")
    fun getAnimeRanking(): Flow<List<AnimeEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAnime(animes: List<AnimeEntity>)

    @Update
    fun updateFavoriteAnime(anime: AnimeEntity)
}