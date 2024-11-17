package com.izzulhaqfs.theozunimearchiveapp.core.data.source.remote.network

import com.izzulhaqfs.theozunimearchiveapp.core.data.source.remote.response.AnimeListResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("/v2/anime")
    suspend fun getAnimeList(
        @Header("X-MAL-CLIENT-ID")
        clientId: String,

        @Query("q")
        query: String,

        @Query("fields")
        fields: String
    ): AnimeListResponse

    @GET("v2/anime/season/{year}/{season}")
    suspend fun getSeasonalAnime(
        @Header("X-MAL-CLIENT-ID")
        clientId: String,

        @Path("year")
        year: Int,

        @Path("season")
        season: String,

        @Query("fields")
        fields: String
    ): AnimeListResponse

    @GET("v2/anime/ranking")
    suspend fun getAnimeRanking(
        @Header("X-MAL-CLIENT-ID")
        clientId: String,

        @Query("ranking_type")
        rankingType: String,

        @Query("fields")
        fields: String
    ): AnimeListResponse
}