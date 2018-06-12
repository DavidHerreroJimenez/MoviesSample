package dherrero.moviessample.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dherrero.moviessample.MoviesApplication
import dherrero.moviessample.data.repository.MoviesRepository
import dherrero.moviessample.data.repository.MoviesRepositoryImpl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Project name: MoviesSample
 * Package name: dherrero.moviessample.di
 *
 * Created by dherrero on 12/06/18.
 */
@Module
class ApplicationModule(private val moviesApplication: MoviesApplication){

    @Provides
    @Singleton
    fun provideApplicationContext(): Context = moviesApplication

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {

        return Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/4/list/1")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

    }

    @Provides
    @Singleton
    fun provideMoviesRepository(moviesRepositoryImpl: MoviesRepositoryImpl): MoviesRepository {

        return moviesRepositoryImpl
    }



}