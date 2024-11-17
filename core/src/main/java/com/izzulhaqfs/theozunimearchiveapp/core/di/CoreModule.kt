package com.izzulhaqfs.theozunimearchiveapp.core.di

import androidx.room.Room
import com.izzulhaqfs.theozunimearchiveapp.core.data.AnimeRepository
import com.izzulhaqfs.theozunimearchiveapp.core.data.source.local.LocalDataSource
import com.izzulhaqfs.theozunimearchiveapp.core.data.source.local.room.AnimeDatabase
import com.izzulhaqfs.theozunimearchiveapp.core.data.source.remote.RemoteDataSource
import com.izzulhaqfs.theozunimearchiveapp.core.data.source.remote.network.ApiService
import com.izzulhaqfs.theozunimearchiveapp.core.domain.repository.IAnimeRepository
import com.izzulhaqfs.theozunimearchiveapp.core.utils.AppExecutors
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory { get<AnimeDatabase>().animeDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            AnimeDatabase::class.java,
            "anime_db"
        ).fallbackToDestructiveMigration().build()
    }
}

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.myanimelist.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<IAnimeRepository> {
        AnimeRepository(
            get(),
            get(),
            get()
        )
    }
}