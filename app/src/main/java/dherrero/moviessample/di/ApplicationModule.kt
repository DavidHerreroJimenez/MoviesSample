package dherrero.moviessample.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dherrero.moviessample.MoviesApplication
import dherrero.moviessample.data.repository.MoviesRepository
import dherrero.moviessample.data.repository.MoviesRepositoryImpl
import dherrero.moviessample.domain.model.Movies
import dherrero.moviessample.domain.usecases.BaseUseCase
import dherrero.moviessample.domain.usecases.None
import dherrero.moviessample.domain.usecases.UseCase
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
                .baseUrl("https://api.themoviedb.org/4/list/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

    }




    @Provides
    @Singleton
    fun provideMoviesRepository(moviesRepositoryImpl: MoviesRepositoryImpl): MoviesRepository {

        return moviesRepositoryImpl
    }


    @Provides
    @Singleton
    fun provideUseCase(useCase: UseCase<Movies>): BaseUseCase{
        return useCase
    }


//    @Provides
//    @Singleton
//    fun provideMovies(movies: Movies): Movies{
//
//        return movies
//    }

    @Provides
    @Singleton
    fun provideMovies(): Movies{

        return Movies()
    }





//    @Provides
//    @Singleton
//    fun provideNone(none: None): None{
//        return none
//    }

    @Provides
    @Singleton
    fun provideNone(): None{
        return None()
    }



}