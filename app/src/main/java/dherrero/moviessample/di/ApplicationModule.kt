package dherrero.moviessample.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dherrero.moviessample.MoviesApplication
import dherrero.moviessample.data.repository.MoviesRepository
import dherrero.moviessample.data.repository.MoviesRepositoryImpl
import dherrero.moviessample.data.rest.entities.ThemoviedbList1
import dherrero.moviessample.domain.usecases.BaseUseCase
import dherrero.moviessample.domain.usecases.None
import dherrero.moviessample.domain.usecases.UseCase
import dherrero.moviessample.ui.MoviesFragment
import dherrero.moviessample.ui.view.MoviesFragmentViewCallBack
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
    fun provideMoviesFragmentViewCallBack(moviesFragment: MoviesFragment): MoviesFragmentViewCallBack{

        return moviesFragment
    }


    @Provides
    @Singleton
    fun provideUseCase(useCase: UseCase<ThemoviedbList1>): BaseUseCase{
        return useCase
    }


//    @Provides
//    @Singleton
//    fun provideFragmentView(moviesFragment: MoviesFragment): MoviesFragmentView{
//        return moviesFragment
//    }


//    @Provides
//    @Singleton
//    fun provideMovies(movies: Movies): Movies{
//
//        return movies
//    }







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