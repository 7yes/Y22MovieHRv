package com.sevenyes.w5moviesrvhiltmvvm.di

import com.sevenyes.w5moviesrvhiltmvvm.movieapi.IMovieRepository
import com.sevenyes.w5moviesrvhiltmvvm.movieapi.MovieAPI
import com.sevenyes.w5moviesrvhiltmvvm.movieapi.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
class RestModule {

@Provides
    fun providesInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    fun providesOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient): MovieAPI {
        return Retrofit.Builder()
            .baseUrl(MovieAPI.BASE_PATH)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(MovieAPI::class.java)
    }

    @Provides
    fun providesMovieRepository(movieAPI: MovieAPI): IMovieRepository {
        return MovieRepository(movieAPI)
    }

}