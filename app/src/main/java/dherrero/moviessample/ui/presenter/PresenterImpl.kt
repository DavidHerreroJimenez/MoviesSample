package dherrero.moviessample.ui.presenter

import dherrero.moviessample.data.errors.CustomError
import dherrero.moviessample.data.repository.MoviesRepositoryImpl
import dherrero.moviessample.domain.model.Movie
import dherrero.moviessample.domain.model.Movies
import dherrero.moviessample.domain.usecases.None
import dherrero.moviessample.domain.usecases.UseCase
import javax.inject.Inject

/**
 * Project name: MoviesSample
 * Package name: dherrero.moviessample.ui.presenter
 *
 * Created by dherrero on 12/06/18.
 */
class PresenterImpl @Inject constructor(val useCase: UseCase<Movies>): Presenter{

    lateinit var moviesList: List<Movie>
    lateinit var error: CustomError

    fun loadMovies(){
        useCase.execute{it.either(::getError, ::addMoviesToMoviesList)}

    }

    fun addMoviesToMoviesList(movies: List<Movie>){
        moviesList = movies
    }

    fun getError(customError: CustomError){
        this.error = customError
    }

}