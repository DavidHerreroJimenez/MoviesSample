package dherrero.moviessample.ui.presenter

import dherrero.moviessample.data.errors.CustomError
import dherrero.moviessample.data.errors.Either
import dherrero.moviessample.data.repository.MoviesRepositoryImpl
import dherrero.moviessample.domain.model.Movie
import dherrero.moviessample.domain.usecases.UseCase
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Project name: MoviesSample
 * Package name: dherrero.moviessample.ui.presenter
 *
 * Created by dherrero on 12/06/18.
 */
//@Singleton
class PresenterImpl @Inject constructor(private val moviesRepositoryImpl: MoviesRepositoryImpl): Presenter{

//    @Inject lateinit var moviesRepositoryImpl: MoviesRepositoryImpl

    fun loadMovies(){
//        moviesRepositoryImpl.getMovies()
        moviesRepositoryImpl.execute((Either<CustomError, List<Movie>>), UseCase.None())
    }

}